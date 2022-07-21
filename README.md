# Plant Shop Project
 
 This project created to test my progaming skill on java
 
 ## Sofware requirement
 - Apache Netbeans: Download netbeans version here [Netbeans download](https://netbeans.apache.org/download/index.html)
 - Database: 
   * MS SQL (recommendation): Follow instructions to install MSSql Server [Doc.Microsoft](https://docs.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver16)
   *  MySql: Follow instruction to install MySql [MySql docs](https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/)
 
 ## Install dependence 
 
**JDK 11**
 - Follow instructions to install the latest version of JDK [oracle docs](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)
 
 **Tomcat server**
 - Follow instructions to install the latest version of Tomcat server [oracle docs](https://docs.oracle.com/cd/E40518_01/studio.310/studio_install/src/tidi_studio_tomcat_install_tomcat_deploy_dependencies.html)

## Create database for project
- You can find the script of MS SQL Server and MySql on file folder databaseScript
- By default will have admin account with user name and password "admin" 

## Setup before run project
- Depend on database you using code will have difference change in file DBUtils.java as folder datdh.utils
- ![DBUtils code](https://github.com/noname163/prj-project/blob/main/gitImg/Screenshot%20(41).png)
  - If you using MS SQL Server you will uncomment the code from line 17 to line 22 and 28 to 35
  - If you using MySql you will uncomment the code from line 24 to 26 and 38 to line 47
- Uncomment command in MacOS 'command' + '/' and in Windows are 'Ctrl' + '/'
- Depend on your machine you will need to change port number, user name, password in code
## Run project 
- Open project name "PlanShop" and run it in Nerbeans IDE  
## Error handling
- All erros will redirect to errosPage.jsp
![Erros Page](https://github.com/noname163/prj-project/blob/main/gitImg/Screenshot%20(42).png)
## Endpoints

## Get
## This project work best on netbeans IDE using jdk8, tomcat 8 or 9, sql server 2019
