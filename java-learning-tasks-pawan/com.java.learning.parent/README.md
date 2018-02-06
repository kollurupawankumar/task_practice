# Steps to generate multi module maven project
1. create a folder and enter into that folder
2. Run the following line in the command line : mvn archetype:generate -DgroupId=com.parent.module -DartifactId=com.parent.module

3. Edit the pom.xml and replacing the packaging tag with <packaging>pom<packaging> 
4. Now create the new child modules with same mvn archetype:generate command
