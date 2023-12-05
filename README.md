# java cipipeline project 
# v1.0.2
The main goal of the project was to create a pipeline for java project which will:
 - change project version
 - build project
 - test project
 - save created artifact on github (executable .jar file)
 - put app into docker container and push to docker hub repo (2 containers - one for production and one for development)
   
# Changing project version
Problem
If we want to change version through pom.xml in the workflow, we have to commit the changes to see updated pom in the repo but I didnt want to make code changes inside the workflow. The problem is that the workflow should be triggered every time we try to modify the main branch so this kinda transgress adpoted rules.

Solution:
Pom.xml of the project is still modified inside the workflow but we dont commit the changes. We store info about project version in git tags instead. In the result we dont see updated pom.xml in the repository but we have information about the version in the latest git tag. 

Project workflow when using this pipeline:
1) Developer creates changes in code
2) If the changes are sufficient to mark them with the new project version dev add tag with new version
3) Dev pushes changes to remote branch and makes pull request (workflow is triggered when making pull request)
4) Workflow updates project version build project, tests it creates artifact and containers (if any of this process fails, all workflow fails)

