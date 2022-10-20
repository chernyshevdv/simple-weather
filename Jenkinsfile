pipeline {
	agent any

	stages {
		stage("build"){
			steps {
				echo 'building application...'
				sh 'mvn package'
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
