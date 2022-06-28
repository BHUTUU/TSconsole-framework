#!/bin/bash
stepper() {
  local inputNum=${1}
  out=$(($inputNum * 2))
}
digitEq() {
  local inputNum=${1}
  out=1
  local counter=0
  participants=(1)
  while true; do
    stepper $out
    participants+=($out)
    if [[ $out -gt $inputNum ]]; then
      maxRange=${participants[$counter]}
      unset participants[-1]
      break
    fi
    let counter++
  done
  parseOpp $inputNum
}
parseOpp() {
  for i in ${participants[@]}; do
    echo $i;
  done | tac
}
outlet=`digitEq $1`
binaryOut() {
#  set -x
  local inputNum="$1"
  evaluate=${outlet[1]}
  finalElements=()
  for j in ${outlet[@]}; do 
    evaluate=$(($evaluate + $j))
    if [[ $evaluate -lt $inputNum ]]; then
      finalElements+=(1)
    elif [[ $evaluate -eq $inputNum ]]; then
      finalElements+=(1)
    elif [[ $evaluate -gt $inputNum ]]; then
      finalElements+=(0)
      evaluate=$(($evaluate - $j))
    fi
  done
#  set +x
}
binaryOut $1
for m in ${finalElements[@]}; do
  output+=$m
done
printf "$output\n"
