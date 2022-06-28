#!/bin/bash
argToArray() {
  local binaryInput="$1"
  local counter=0
  normalArray=()
  while true;do
    if [ -z ${binaryInput:${counter}:1} ]; then break;fi
    normalArray+=($(printf "${binaryInput:${counter}:1}"))
    let counter++
  done
}
reverseArray() {
  for i in ${normalArray[@]}; do
    echo "$i"
  done | tac
}
main() {
  argToArray $1
  reversedArray=`reverseArray $1`
  local counter=1
  sum=0
  for j in ${reversedArray[@]}; do
    if [[ $j -eq 1 ]]; then
      sum=$(($sum + $counter))
    fi
    counter=$((counter * 2))
  done
}
main $1
echo $sum
