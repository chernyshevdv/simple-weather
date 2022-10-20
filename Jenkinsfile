pipeline {
	agent any

	stages {
		stage("package"){
			steps {
				echo 'building application...'
				sh 'mvn build'
			}
		}
		stage("test"){
			steps {
				echo 'testing the app...'
				sh 'mvn test'
			}
		}
		stage("deploy"){
			steps {
				echo 'deploying the app...'
			}
		}
	}
}
