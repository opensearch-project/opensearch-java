#!/usr/bin/env bash

set -ex

IFS='.' read -r -a VERSION_COMPONENTS <<< "$1"
MAJOR="${VERSION_COMPONENTS[0]}"
MINOR="${VERSION_COMPONENTS[1]}"
PATCH="${VERSION_COMPONENTS[2]}"

if [[ -z "$MAJOR" || -z "$MINOR" || -z "$PATCH" ]]; then
  echo "Usage: $0 <major>.<minor>.<patch>"
  exit 1
fi

VERSION="$MAJOR.$MINOR.$PATCH"

s=$(command -v gsed || command -v sed)

if [[ -z "$s" ]]; then
  echo "sed command not found. Please install gsed or sed."
  exit 1
fi

"$s" -i'' -E "s/^(systemProp\.version =) [0-9]+\.[0-9]+\.[0-9]+/\1 $VERSION/" gradle.properties