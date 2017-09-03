!include "MUI2.nsh"

Name "Agenda Grupo 2"
Outfile "AG2installer.exe"
XPStyle on

!insertmacro MUI_PAGE_WELCOME
!insertmacro MUI_PAGE_DIRECTORY
!insertmacro MUI_PAGE_COMPONENTS
!insertmacro MUI_PAGE_INSTFILES
#!insertmacro MUI_PAGE_FINISH

!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES

InstallDir "$PROGRAMFILES\AgendaTpiG2"

!insertmacro MUI_LANGUAGE "Spanish"

section
  ExecWait '"dependencias\jre-8u144-windows-i586.exe" /s'
  SetOutPath $TEMP
  File "dependencias\mariadb-10.2.8-win32.msi"
  ExecWait 'msiexec /i $TEMP\mariadb-10.2.8-win32.msi SERVICENAME=MARIADB PASSWORD=root ADDLOCAL=DBInstance,MYSQLSERVER,Client /qn'
  File "sql\scriptAgenda.sql"
  ExpandEnvStrings $0 %COMSPEC%
  ExecWait `"$0" /C "$PROGRAMFILES\Mariadb 10.2\bin\mysql" -u root -proot < $TEMP\scriptAgenda.sql`
SectionEnd

section
  SetShellVarContext all
  setOutPath $INSTDIR
  File Readme.txt
  File Agenda2019.jar
  File /r "reportes"
  File "icono.ico"
sectionEnd

section "Start Menu shortcut" StartMenuLnk
  createShortCut "$SMPROGRAMS\AgendaTpiG2.lnk" "$INSTDIR\Agenda2019.jar" "" "$INSTDIR\icono.ico"
sectionEnd

section "Desktop shortcut" DesktopLnk
  createShortCut "$DESKTOP\AgendaTpiG2.lnk" "$INSTDIR\Agenda2019.jar" "" "$INSTDIR\icono.ico"
sectionEnd

; Section descriptions

LangString DESC_DesktopLnk ${LANG_SPANISH} \
           "Crear un icono en el escritorio."
LangString DESC_StartMenuLnk ${LANG_SPANISH} \
           "A�adir una entrada en el menu inicio."

!insertmacro MUI_FUNCTION_DESCRIPTION_BEGIN
  !insertmacro MUI_DESCRIPTION_TEXT ${DesktopLnk} $(DESC_DesktopLnk)
  !insertmacro MUI_DESCRIPTION_TEXT ${StartMenuLnk} $(DESC_StartMenuLnk)
!insertmacro MUI_FUNCTION_DESCRIPTION_END
