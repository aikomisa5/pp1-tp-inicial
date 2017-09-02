

#Nombre del directorio
!define NOMBRE "Agenda2019"
#Tamaño necesario para la instalacion
!define INSTALLSIZE 150000000
#Directorio de instalacion
InstallDir "$PROGRAMFILES\${NOMBRE}"

ShowInstDetails show

#Nombre del instalador
outFile "MariaDBInstaller.exe"

#Paginas que queremos usar
 Page license
 #Page components
 Page directory
 Page instfiles

 #Lo que va a decir la licencia
 LicenseData "Readme.txt"


Section "instaladorJar"
	#seteamos el destino
	setOutPath $INSTDIR
	#Elegimos los archivos que queremos instalar, en caso de que sea una carpeta ponemos /r + "nombreCarpeta"
	File Readme.txt
	File Agenda2019.jar
	File /r "reportes"
  File /r "sql"
	File "icono.ico"



	#aca ejecutamos los instaladores de jre y mysql el /s es para la instalacion silenciosa

	ExecWait '"dependencias\jre-8u144-windows-i586.exe" /s'

	createShortCut "$DESKTOP\Agenda2019.lnk" "$INSTDIR\Agenda2019.jar" "" "$INSTDIR\icono.ico" #

	#Con esto se informa el tamaño de la 	createShortCut "$DESKTOP" -jar $\"$INSTDIR\programa.jar" "" "$INSTDIR\icono.ico" #instalacion
	WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\${NOMBRE}" "EstimatedSize" ${INSTALLSIZE}

	#Ahora instalamos mysql
	#Elegimo temp como carpeta de salida
	setOutPath $TEMP

	#Elegimos el archivo e instalamos
  #File "dependencias\mariadb-10.2.8-win32.msi"
  #ExecWait 'msiexec /i $TEMP\mariadb-10.2.8-win32.msi INSTALLDIR="$INSTDIR\MariaDB\" SERVICENAME=MySQL PASSWORD=root /qn'
  #ExecWait 'msiexec /i $TEMP\mariadb-10.2.8-win32.msi INSTALLDIR="$INSTDIR\MariaDB\" /qn'
  #ExecWait '$INSTDIR\MariaDB\bin\mysql -u root -proot < $\"$INSTDIR\sql\scriptAgenda.sql$\"'

  setOutPath $TEMP

  #Elegimos el archivo e instalamos
  File "sql\scriptAgenda.sql"
  File "dependencias\mariadb-10.2.8-win32.msi"
  ExecWait 'msiexec /i $TEMP\mariadb-10.2.8-win32.msi SERVICENAME=MARIADB PASSWORD=root ADDLOCAL=DBInstance,MYSQLSERVER,Client /qn'
  ExpandEnvStrings $0 %COMSPEC%
  ExecWait `"$0" /C "$PROGRAMFILES\Mariadb 10.2\bin\mysql" -u root -proot < $TEMP\scriptAgenda.sql`



SectionEnd
