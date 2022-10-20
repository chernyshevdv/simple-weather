pipeline {
	agent any

	stages {
		stage("build"){
			echo 'building application...'
			sh 'mvn build'
		}
		stage("test"){
			echo 'testing the app...'
			sh 'mvn test'
		}
		stage("deploy"){
			echo 'deploying the app...'
		}
	}
}
