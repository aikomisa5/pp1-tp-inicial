

#Nombre del directorio
!define NOMBRE "Agenda2017"
#Tamaño necesario para la instalacion
!define INSTALLSIZE 150000000
#Directorio de instalacion
InstallDir "$PROGRAMFILES\${NOMBRE}"

ShowInstDetails show

#Nombre del instalador
outFile "instaler.exe"

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
	File Agenda2017.jar
	File /r "reportes"
	File "icono.ico"

	
	
	#aca ejecutamos los instaladores de jre y mysql el /s es para la instalacion silenciosa

	ExecWait '"dependencias\jre-8u144-windows-i586.exe" /s'

	#esto no funciona, es lo que queda averiguar
	#msiexec '/i "dependencias\mysql-installer-community-5.7.17.0.msi" /qn' -silent
	#ExecWait '"$SYSDIR\msiExec" /i "dependencias\mysql-installer-community-5.7.17.0.msi" /passive'
	#esto crasheaba
	#ExecWait '"$SYSDIR\msiExec.exe" /i "dependencias\mysql-installer-community-5.7.17.0.msi" /s'
	
	#Goto crearAccesos	
	
	#ExecWait '"$TEMP\dependencias\mysql-installer-community-5.7.17.0.msi" /qn'
	
	
	#crearAccesos:
	createShortCut "$DESKTOP\Agenda2017.lnk" "$INSTDIR\programa.jar" "" "$INSTDIR\icono.ico" #

	#Con esto se informa el tamaño de la 	createShortCut "$DESKTOP" -jar $\"$INSTDIR\programa.jar" "" "$INSTDIR\icono.ico" #instalacion
	WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\${NOMBRE}" "EstimatedSize" ${INSTALLSIZE}
	
	#Ahora instalamos mysql
	#Elegimo temp como carpeta de salida
	setOutPath $TEMP
	
	#Elegimos el archivo e instalamos
	File "dependencias\mysql-installer-community-5.7.17.0.msi"
	nsExec::Exec 'msiexec /i $TEMP\mysql-installer-community-5.7.17.0.msi /passive CONSOLEARGS="install server;5.7.17;x86:*:type=config;openfirewall=true;generallog=true;binlog=true;serverid=1;enable_tcpip=true;port=3306;rootpasswd=root:type=user;username=root;password=root;role=DBManager -silent"'

	
SectionEnd

