# Insert-Game com JSF
♦ Cadastro simples de Jogos e vinculo à lista de plataformas, com mapeamento @ManyToOne e @OneToMany, Cascade.ALL etc.


                                                                SOBRE O PROJETO
           • Projeto em JSF + Primefaces
           • Banco Postgres
           • Hibernate na camada de persistência 
           • Servidor TomCat v8.5
		   
		   A URL de acesso é: http://localhost:8080/crud-jsf/game.xhtml
           
           
O projeto tem como implementação um **Dao** Generico para fazer a persistência no banco de dados, esse Dao pode ser injetado nos serviços necessários e termos assim  
classes de serviços mais "Limpas".  

A entidade **GamesModel** é anotada com @Entity, fazendo com que as configurações pré-setadas no persistence.xml entrem em ação e crie a tabela no banco de dados.  
já o banco de dados em si deve ser criado manualmente com a seguinte Query **[ CREATE DATABASE games_db; ]** a partir daí o hibernate cria as tabelas com essas anotações @Entity.  
----------------------------------------------------------------///----------------------------------------------------------------
                  
    Na camada web temos os campos de input **Game** , **Desenvolvedora** , **Genero** , e **Plataformas** .  
a Entidade **GamesModel** recebe os dados dos 3 primeiros inputs e + uma Lista de plataformas na qual é outra entidade (**PlataformaModel**), o relacionamento **@OneToMany**  
e **@ManyToOne** faz com que liguemos essas classes por atributos especificos, com a junção do cascadeType.ALL a lista de plataformas é salva assim que salvamos um Game,  
de forma "cascateada".  
Para Salvarmos um Game precisamos informar os valores necessários nos inputs e adicionar em uma lista separada as plataformas, ou seja, digitamos uma plataforma e clicamos em "+",  
digitamos outra e clicamos novamente em "+", e será notado que uma outra lista é iterada logo abaixo só com as plataformas, após isso é só persistir clicando no botão "Cadastrar", teremos todas as plataformas listadas salvas e vinculadas ao ID do game, e clicando na **Lupa** poderemos ver o "Resumo" onde é possivel filtrar um resultado e até mesmo ver as plataformas setadas anteriormente, tudo isso atravéz do **Dialog FrameWork** do **Primefaces**.

# Relação de imagens  (Depreciada)
 Foi implementada uma API de busca o **"Web Search API"** , essa API faz a busca de imagens baseada no nome inserido na coluna da tabela, na qual fica localizada na página de dialogView.xhtml, ou seja, ao cadastrarmos o game a API entra em ação buscando   
 o nome inserido e automaticamente retornando um array de resultados onde precisaremos de algum index, que no meu caso eu utilizei o index 0 (zero) e pegando a URL para montar o PATH da imagem, lembrando que ao inserirmos o nome do game, em muitos casos temos  
 o espaçamento entre palavras, o que quebrará o link e consequentemente a busca realizada, retornando um erro 500, para evitar isso deverá ser inserido um **"replaceAll()"** ao path original, transformando a nome que virá do input nomeGame para valores no link, esses valores são a conversão de espaços vazios   >>" "<<  
 para **"%20"** que representa um espaçamento na tabela ASCII.
 Essa API por ser gratuita possui um limite de 100 requisições por dia, caso esse limite seja atingido a página dialogView.xhtml será retornada com um erro 500, para evitar isso foi inserida uma condição que traz uma imagem padrão do Google Drive, essa imagem possui a frase "IMAGEM TEMPORARIAMENTE INDISPONIVEL"  
 assim temos o acesso normal a dialogView.xhtml e podemos fazer as consultas normalmente. (Depreciada)
 
 ==============================================================#========================================
 
           Para a nova busca de imagens agora é usado o Webscraping no google imagens na qual busca o nome do game na coluna e seta a imagem no momento que abrimos o dialogView.xhtml, nesse caso não temos mais o problema de limite nas requisições.

► Qualquer dúvida é só entrar em contato via E-Mail **delsonsaint@hotmail.com** .  



           
           
                       
