#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    environment {
        IMAGE_NAME = "jason8746/my-app:1.0.1-java-multi-pipeline-amd64"
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            when {
                expression {
                    gv.masterBranch()
                }
            }
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
