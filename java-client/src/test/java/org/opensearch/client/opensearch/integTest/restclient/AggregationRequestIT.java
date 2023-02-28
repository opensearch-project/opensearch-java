/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.restclient;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.http.HttpHost;
import org.junit.Test;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.aggregations.Aggregation;
import org.opensearch.client.opensearch._types.aggregations.AggregationRange;
import org.opensearch.client.opensearch._types.aggregations.DateRangeAggregation;
import org.opensearch.client.opensearch._types.aggregations.DateRangeExpression;
import org.opensearch.client.opensearch._types.aggregations.FieldDateMath;
import org.opensearch.client.opensearch._types.aggregations.RangeAggregation;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.integTest.AbstractRequestIT;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.rest_client.RestClientTransport;
import org.opensearch.common.settings.Settings;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

public class AggregationRequestIT extends AbstractRequestIT {

    @Override
    public OpenSearchTransport buildTransport(Settings settings, HttpHost[] hosts) throws IOException {
        return new RestClientTransport(buildClient(settings, hosts), new JacksonJsonpMapper());
    }

    @Test
    public void testValueRangeAggregation() throws Exception {
        var index = "test-value-range-aggregation";
        createDateRangeDocuments(index);
        var searchResponse = sendAggregateRequest(index, "cost_ranges", getCostValueRangeAggregation());
        var costRangesAggregations = searchResponse.aggregations().get("cost_ranges");
        var buckets = costRangesAggregations._get()
                ._toAggregate()
                .range()
                .buckets()
                .array();

        assertEquals(3, buckets.size());
        assertEquals(2, buckets.get(0).docCount());
        assertEquals(2, buckets.get(1).docCount());
        assertEquals(2, buckets.get(2).docCount());
    }

    @Test
    public void testDateRangeAggregation() throws Exception {
        var index = "test-date-range-aggregation";
        createDateRangeDocuments(index);
        var searchResponse = sendAggregateRequest(index, "expiry_ranges", getExpiryDateRangeAggregation());
        var expiryRangesAggregations = searchResponse.aggregations().get("expiry_ranges");
        var buckets = expiryRangesAggregations._get()
                ._toAggregate()
                .dateRange()
                .buckets()
                .array();

        assertEquals(3, buckets.size());
        assertEquals(2, buckets.get(0).docCount());
        assertEquals(2, buckets.get(1).docCount());
        assertEquals(2, buckets.get(2).docCount());
    }

    private Aggregation getExpiryDateRangeAggregation() {
        DateRangeAggregation expiryDateRangeAggregation = new DateRangeAggregation.Builder()
                .field("expDate")
                .ranges(getDateAggregationRanges())
                .build();
        return new Aggregation.Builder().dateRange(expiryDateRangeAggregation).build();
    }

    private Aggregation getCostValueRangeAggregation() {
        RangeAggregation costValueRangeAggregation = new RangeAggregation.Builder()
                .field("cost")
                .ranges(getValueAggregationRanges())
                .build();
        return new Aggregation.Builder().range(costValueRangeAggregation).build();
    }

    private SearchResponse<Void> sendAggregateRequest(String index, String key, Aggregation value) throws IOException {
        return javaClient().search(
                request -> request.index(index)
                        .size(0)
                        .aggregations(key, value),
                Void.class);
    }

    private List<DateRangeExpression> getDateAggregationRanges() {
        return List.of(
                new DateRangeExpression.Builder()
                        .from(builder -> builder.value((double) getDatePlusDays(1).getTime()))
                        .to(FieldDateMath.of(builder -> builder.value((double) getDatePlusDays(3).getTime() - 1000)))
                        .key("from-1-to-2-days")
                        .build(),
                new DateRangeExpression.Builder()
                        .from(builder -> builder.value((double) getDatePlusDays(3).getTime()))
                        .to(FieldDateMath.of(builder -> builder.value((double) getDatePlusDays(5).getTime() - 1000)))
                        .key("from-3-to-4-days")
                        .build(),
                new DateRangeExpression.Builder()
                        .from(builder -> builder.value((double) getDatePlusDays(5).getTime()))
                        .to(FieldDateMath.of(builder -> builder.value((double) getDatePlusDays(7).getTime() - 1000)))
                        .key("from-5-to-6-days")
                        .build()
        );
    }

    private List<AggregationRange> getValueAggregationRanges() {
        return List.of(
                new AggregationRange.Builder().to("10").build(),
                new AggregationRange.Builder().from("10").to("30").build(),
                new AggregationRange.Builder().from("30").build()
        );
    }

    private void createDateRangeDocuments(String index) throws IOException {
        javaClient().create(_1 -> _1.index(index).id("1").document(createProduct("egg", 2, 1)).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index(index).id("2").document(createProduct("meat", 15, 2)).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index(index).id("3").document(createProduct("ham", 30, 3)).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index(index).id("4").document(createProduct("cheese", 25, 4)).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index(index).id("5").document(createProduct("pasta", 8, 5)).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index(index).id("6").document(createProduct("oil", 50, 6)).refresh(Refresh.True));
    }

    private ProductDetails createProduct(String name, int cost, int plusDays) {
        return new ProductDetails(name, cost, getDatePlusDays(plusDays));
    }

    private Date getDatePlusDays(int plusDays) {
        return java.sql.Date.from(LocalDateTime.of(2023, 2, 20, 0, 0, 0).plusDays(plusDays).toInstant(ZoneOffset.UTC));
    }

    public static class ProductDetails {
        private String name;
        private int cost;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
        private Date expDate;

        public ProductDetails() {
        }

        public ProductDetails(String name, int cost, Date expDate) {
            this.name = name;
            this.cost = cost;
            this.expDate = expDate;
        }

        public String getName() {
            return name;
        }

        public int getCost() {
            return cost;
        }

        public Date getExpDate() {
            return expDate;
        }
    }
}
