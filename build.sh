node {
    
    git 'https://github.com/simraninovation/BankManagementApi.git'
  
    
        stage('Compilation and Analysis') {
            
                bat "./mvnw clean install"
    
              
           
        }
         stage('Test') {
            
                bat "./mvnw test"
    
              
           
        }
        stage('Deploy') {
            
                bat './mvnw spring-boot:run -Dserver.port=8989'
    
              
           
        }
        
        
        
             
        
        
    
}
