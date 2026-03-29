# Criptografia Aplicada: Assinatura Digital em Java 

Este repositório contém um exercício prático desenvolvido para a cadeira de **Criptografia Aplicada**. O objetivo principal do programa é demonstrar o funcionamento de assinaturas digitais utilizando a API nativa `java.security` do Java.

## Funcionalidades

O projeto é composto por dois programas principais:

1. **`Assinar.java`**:
   * Gera um par de chaves RSA (Pública e Privada) de 1024 bits.
   * Lê um ficheiro de texto fornecido pelo utilizador.
   * Gera uma assinatura digital desse ficheiro utilizando o algoritmo `SHA1withRSA` e a chave privada.
   * Exporta a assinatura gerada (`Assinatura.sig`) e a chave pública (`ChavePublica.pub`) para ficheiros.

2. **`Validar.java`**:
   * Importa a chave pública exportada.
   * Importa a assinatura digital exportada.
   * Lê o ficheiro de texto original.
   * Valida criptograficamente se a assinatura corresponde ao ficheiro utilizando a chave pública.

## Pré-requisitos

* Java Development Kit (JDK) instalado (versão 8 ou superior).
* Um IDE (IntelliJ IDEA, Eclipse) ou acesso à linha de comandos (Terminal/CMD).

## Como Compilar e Executar (Linha de Comandos)

Antes de começar, crie um ficheiro de texto simples na mesma diretoria (ex: `documento.txt`) com algum conteúdo para ser assinado.

### Passo 1: Compilar o código
```bash
javac Assinar.java Validar.java
```
### Passo 2: Assinar o documento
```bash
java Assinar documento.txt
```
### Passo 3: Validar a assinatura
```bash
java Validar ChavePublica.pub Assinatura.sig documento.txt
```
