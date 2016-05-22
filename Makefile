# Kyle Matsumoto
# kytmatsu
# CMPS012B
# 10/22/14
# This file creates an executable JAR when used with Business Search.
# 
#
JAVASRC = BusinessSearch.java
SOURCES = README makefile ${JAVASRC}
MAINCLASS = BusinessSearch
CLASSES = BusinessSearch.class
JARFILE = BusinessSearch
JARCLASSES = ${CLASSES}
all: ${JARFILE}
${JARFILE}: ${CLASSES}
	echo "Main-class: ${MAINCLASS}" > Manifest
	jar cvfm ${JARFILE} Manifest ${JARCLASSES}
	rm Manifest
	chmod +x ${JARFILE}
${CLASSES}: ${JAVASRC}
	javac -Xlint ${JAVASRC}
clean:
	rm ${CLASSES} ${JARFILE}
.PHONY: clean all
