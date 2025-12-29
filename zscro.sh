#!/bin/bash
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
java "$SCRIPT_DIR/zscro.java" "$@"
