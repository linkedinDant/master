#!/bin/bash

export CUPS_VERSION=1.6.3
export ALSA_VERSION=1.0.27.2
export FREETYPE_VERSION=2.5.0
export INSTALL_ROOT_DIR=test_rep
cd ~
echo "Installation des paquets debian"
sudo apt-get install gcc g++ build-essential ccache openjdk-7-jdk zip tar unzip mercurial
sudo apt-get install libxrender-dev libxtst-dev libX11-dev libxext-dev libxrender1
mkdir -p ${INSTALL_ROOT_DIR}/lib/build
cd ${INSTALL_ROOT_DIR}
hg clone http://hg.openjdk.java.net/jdk8/jdk8
cd jdk8
chmod +x get_source.sh configure
cd ../lib
mkdir build/cups build/freetype build/alsa

# Installation de CUPS
echo "Téléchargement de CUPS..."
wget -O cups.tar.bz2 http://cups.org/software/${CUPS_VERSION}/cups-${CUPS_VERSION}-source.tar.bz2
tar -jxf cups.tar.bz2
rm cups.tar.bz2
mv cups-* cups
cd cups
echo "Installation de CUPS..."
./configure --prefix=${HOME}/${INSTALL_ROOT_DIR}/lib/build/cups
make
sudo make install
echo "CUPS a été correctement installé"

#Installation d'ALSA
echo "Téléchargement d'ALSA..."
cd ~/${INSTALL_ROOT_DIR}/lib/
wget -O alsa.tar.gz ftp://ftp.alsa-project.org/pub/lib/alsa-lib-${ALSA_VERSION}.tar.bz2
tar -xf alsa.tar.gz
rm alsa.tar.gz
mv alsa-* alsa
cd alsa
echo "Installation d'ALSA..."
./configure --prefix=${HOME}/${INSTALL_ROOT_DIR}/lib/build/alsa
make 
make install
echo "ALSA a été correctement installé"

#Installation de Freetype
echo "Téléchargement de Freetype..."
cd ~/${INSTALL_ROOT_DIR}/lib
wget -O freetype.tar.bz2 http://download.savannah.gnu.org/releases/freetype/freetype-${FREETYPE_VERSION}.tar.bz2
tar -jxf freetype.tar.bz2
rm freetype.tar.bz2
mv freetype-* freetype
cd freetype
echo "Installation de Freetype..."
./configure --prefix=${HOME}/${INSTALL_ROOT_DIR}/lib/build/freetype --without-png
make
make install
echo "Freetype a été correctement installé"

#Compilation d'OpenJDK 8
echo "Téléchargement des sources d'OpenJDK"
cd ~/${INSTALL_ROOT_DIR}/jdk8
./get_source.sh
echo "Démarrage de la configuration d'OpenJDK 8..."
./configure --with-alsa=${HOME}/${INSTALL_ROOT_DIR}/lib/build/alsa --with-cups=${HOME}/${INSTALL_ROOT_DIR}/lib/build/cups --with-cups-include=${HOME}/${INSTALL_ROOT_DIR}/lib/build/cups/include --with-freetype=${HOME}/${INSTALL_ROOT_DIR}/lib/build/freetype
make
