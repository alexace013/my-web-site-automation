#!/bin/bash
echo "Run autotests based on Java and Selenium described on BDD style using Cucumber with Gherkin language for my web site:<http://alexanderbakhin.com/>"
echo "START"
echo "."
echo "."
echo "."
echo "searching directory..."
echo "."
echo "."
echo "."
locate -b '\my-web-site-automation'
echo "start tests..."
echo "."
echo "."
echo "."
# mptest - run maven and gradle 'test' builds for my project
alias mptest='pwd;mvn test;gradle test'
# mpctest - run maven and gradle 'clean test' builds for my project
alias mpctest='pwd;mvn clean test;gradle clean test'
mpctest
