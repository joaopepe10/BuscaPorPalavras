# PROCESSO SELETIVO SILLION!

-> Foi passado o seguinte desafio, receber determinada URL, e fazer uma 
busca por determinada palavra, caso seja uma palavra composta, fazer o
fatiamento da mesma, exemplo ("**Blocos** **de** **pedra**", fazer a busca pela palavra
original e as outras palavras sozinhas, "**blocos**", "**de**", "**pedra**").

-> Para fazer tal desafio foi utilizada a biblioteca Jsoup, caso deseja colocar no
seu projeto, é só ter o maven e adicionar o seguinte código no arquivo `pom.xml`

            <dependency>
                    <!-- jsoup HTML parser library @ https://jsoup.org/ -->
                    <groupId>org.jsoup</groupId>
                    <artifactId>jsoup</artifactId>
                    <version>1.16.1</version>
            </dependency>

-> Foi incluido também a dependencia do jUnit para testes unitários, é algo que
não estou muito bem famialirizado, mas estou me aprofundando no assunto, para adicionar 
a depedência é so ir no `pom.xml` e adicionar tbm a dependência: 

        <!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine -->
                <dependency>
                    <groupId>org.junit.jupiter</groupId>
                    <artifactId>junit-jupiter-engine</artifactId>
                    <version>5.9.2</version>
                    <scope>test</scope>
                </dependency>

-> Gostei muito desse desafio pois aprendi muitas coisas com ele, inclusive as famosas expreções regulares, mais conhecidas como
`REGEX`, quebrei a cabeça no começo para entender, porém peguei o jeito .

# Como acessar com o Docker: 

Aplicação dockerizada, para acessar a mesma pode se usar o comando :

`docker pull joaopepe10/sillion:sem-entrada-de-dados`

Quando baixar a image, use o comando: 

`docker run it --name projeto joaopepe10/sillion:sem-entrada-de-dados`