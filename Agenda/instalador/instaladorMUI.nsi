!include "MUI2.nsh"
!define MUI_ICON "icono.ico"
#Nombre del directorio
!define NOMBRE "AgendaTpiG2"
#Nombre del jar de la app.
!define NombreJar "AgendaG2.jar"
#Tamaño necesario para la instalacion
!define INSTALLSIZE 150000000


Name "Agenda Grupo 2"
Outfile "AG2installer.exe"
XPStyle on


!insertmacro MUI_PAGE_WELCOME
!insertmacro MUI_PAGE_DIRECTORY
!insertmacro MUI_PAGE_COMPONENTS
!insertmacro MUI_PAGE_INSTFILES
!insertmacro MUI_PAGE_FINISH

!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES

#Directorio de instalación por defecto.
InstallDir "$PROGRAMFILES\${NOMBRE}"

#Lenguaje de ui del instalador.
!insertmacro MUI_LANGUAGE "Spanish"

!define ADDREM "Software\Microsoft\Windows\CurrentVersion\Uninstall"

section
  #seccion de instalación de dependencias, JRE y MariaDB.
  ExecWait '"dependencias\jre-8u144-windows-i586.exe" /s'
  SetOutPath $TEMP
  File "dependencias\mariadb-10.2.8-win32.msi"
  ExecWait 'msiexec /i $TEMP\mariadb-10.2.8-win32.msi SERVICENAME=MARIADB PASSWORD=root ADDLOCAL=DBInstance,MYSQLSERVER,Client /qn'
  File "sql\scriptAgenda.sql"
  #Obtener el path de la consola y almacenarlo en $0
  ExpandEnvStrings $0 %COMSPEC%
  ExecWait `"$0" /C "$PROGRAMFILES\Mariadb 10.2\bin\mysql" -u root -proot < $TEMP\scriptAgenda.sql`
SectionEnd

section
  #seccion de instalación del jar del proyecto junto con el reporte de jasper y el icono.
  setOutPath $INSTDIR
  File Readme.txt
  File ${NombreJar}
  File /r "reportes"
  File "icono.ico"
sectionEnd

Section
  writeUninstaller $INSTDIR\uninstall.exe
  WriteRegStr HKLM "${ADDREM}\${NOMBRE}" \
                   "DisplayName" "${NOMBRE}"
  WriteRegStr HKLM "${ADDREM}\${NOMBRE}" \
                   "UninstallString" "$\"$INSTDIR\uninstall.exe$\""
  WriteRegStr HKLM "${ADDREM}\${NOMBRE}" \
                   "QuietUninstallString" "$\"$INSTDIR\uninstall.exe$\" /S"
  WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\${NOMBRE}" "EstimatedSize" ${INSTALLSIZE}
SectionEnd

#secciones opcionales (creación de accesos directos)
section "Acceso directo Menú Inicio" StartMenuLnk
  createShortCut "$SMPROGRAMS\${NOMBRE}.lnk" "$INSTDIR\${NombreJar}" "" "$INSTDIR\icono.ico"
sectionEnd

section "Acceso directo Escritorio" DesktopLnk
  createShortCut "$DESKTOP\${NOMBRE}.lnk" "$INSTDIR\${NombreJar}" "" "$INSTDIR\icono.ico"
sectionEnd

#Descripciones de secciones opcionales:
LangString DESC_StartMenuLnk ${LANG_SPANISH} \
           "Añadir una entrada en el menu inicio."
LangString DESC_DesktopLnk ${LANG_SPANISH} \
           "Crear un icono en el escritorio."

#AÃ±adiendo opciones para creación de accesos directos al instalador.
!insertmacro MUI_FUNCTION_DESCRIPTION_BEGIN
  !insertmacro MUI_DESCRIPTION_TEXT ${DesktopLnk} $(DESC_DesktopLnk)
  !insertmacro MUI_DESCRIPTION_TEXT ${StartMenuLnk} $(DESC_StartMenuLnk)
!insertmacro MUI_FUNCTION_DESCRIPTION_END

section "Uninstall"
  delete $INSTDIR\uninstall.exe
  RMDir /r $INSTDIR
  RMDir /r $APPDATA\Roaming\Agenda
  delete "$SMPROGRAMS\${NOMBRE}.lnk"
  delete "$DESKTOP\${NOMBRE}.lnk"

  DeleteRegKey HKLM "${ADDREM}\${NOMBRE}"
sectionEnd
