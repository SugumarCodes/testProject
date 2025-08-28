pipeline{
agent any
stages{
stage('Build')
    {
        echo "Building the project...."
    }
    stage('Test')
    {
        echo "Testing the project....."
    }
    stage('Deploy')
    {
        echo "Deploying the project...."
    }
    stage('Release')
    {
        echo "Releasing the project...."
    }

}
}
