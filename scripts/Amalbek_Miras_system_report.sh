#!/bin/bash
# System report script - Amalbek Miras

STUDENT="Amalbek Miras"
DIR="$(cd "$(dirname "$0")/.." && pwd)"
LOG="$DIR/logs/Amalbek_Miras_system_report.log"

{
echo "========== SYSTEM REPORT =========="
echo "Student: $STUDENT"
echo "Date and time: $(date '+%Y-%m-%d %H:%M:%S')"
echo "User: $(whoami)"
echo "OS: $(grep PRETTY_NAME /etc/os-release | cut -d= -f2 | tr -d '"')"
echo "Kernel: $(uname -r)"
echo "--- CPU ---"
lscpu | grep -E "Model name|^CPU\(s\)"
echo "--- Memory ---"
free -h
echo "--- Disk usage ---"
df -h /
echo "--- Available disk space ---"
df -h / | awk 'NR==2 {print "Available: " $4}'
echo "==================================="
echo
} | tee -a "$LOG"
