#!/bin/sh
sudo yum upgrade
sudo yum update
sudo yum install git
sudo yum install java-1.8.0-openjdk
wget https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.tar.gz
tar xzvf apache-maven-3.8.5-bin.tar.gz
sudo mv apache-maven-3.8.5 /opt/
echo 'export M2_HOME=/opt/apache-maven-3.8.5/bin' >> ~/.bashrc
echo 'export PATH=$M2_HOME:$PATH' >> ~/.bashrc
source ~/.bashrc
mvn -v
echo $M2_HOME
echo $PATH
git clone https://github.com/Charalo/mutantes.git
cd mutantes/
git fetch
git checkout master
mvn spring-boot:run &