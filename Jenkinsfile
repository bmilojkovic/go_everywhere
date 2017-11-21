pipeline {
  agent {
    docker {
      args '-u root'
      image 'maven:3.5'
    }
    
  }
  stages {
    stage('build') {
      steps {
        sh 'mvn install -DskipTests'
      }
    }
    stage('Test') {
      steps {
        sh '''mvn surefire-report:report-only
mvn site || true

testres=`cat ./target/site/surefire-report.html`

curl --request POST \\
  --url \'https://slack.com/api/files.upload?token=xoxb-274935904405-4nIOP4Y0CR0FHayot5dhvK8R\' \\
  --header \'cache-control: no-cache\' \\
  --header \'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW\' \\
  --data-urlencode \'channels=#jenkins\' \\
  --data-urlencode "content=${testres}" \\
  --data-urlencode filename=report.html \\
  --data-urlencode filetype=html \\
  --data-urlencode title=Report'''
      }
    }
    stage('Notify') {
      steps {
        slackSend(message: 'Test', channel: '#jenkins', token: '1f2ifxvLyfoPlr7cyHPxVAsn', baseUrl: 'https://hooks.slack.com/services/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')
      }
    }
    stage('clean') {
      steps {
        cleanWs(cleanWhenFailure: true, cleanWhenAborted: true, cleanWhenNotBuilt: true, cleanWhenSuccess: true, cleanWhenUnstable: true, cleanupMatrixParent: true, deleteDirs: true)
      }
    }
  }
}