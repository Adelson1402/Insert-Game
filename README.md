# Insert-Game com JSF
♦ Cadastro simples de Jogos e vinculo à lista de plataformas, com mapeamento @ManyToOne e @OneToMany, Cascade.ALL etc.


                                                                SOBRE O PROJETO
           • Projeto em JSF + Primefaces
           • Banco Postgres
           • Hibernate na camada de persistência 
           • Servidor TomCat v8.5
           
           
O projeto tem como implementação um **Dao** Generico para fazer a persistência no banco de dados, esse Dao pode ser injetado nos serviços necessários e termos assim  
classes de serviços mais "Limpas".  

A entidade **GamesModel** é anotada com @Entity, fazendo com que as configurações pré-setadas no persistence.xml entrem em ação e crie a tabela no banco de dados.  
já o banco de dados em si deve ser criado manualmente com a seguinte Query **[ CREATE DATABASE games_db; ]** a partir daí o hibernate cria as tabelas com esas anotações @Entity.  
--------------------------------------------------------------------------------///------------------------------------------------
                  
Na camada web temos os campos de input **Game** , **Desenvolvedora** , **Genero** , e **Plataformas** .  
a Entidade **GamesModel** recebe os dados dos 3 primeiros inputs e + uma Lista de plataformas na qual é outra entidade (**PlataformaModel**), o relacionamento **@OneToMany**  
e **@ManyToOne** faz com que liguemos essas classes por atributos especificos, com a junção do cascadeType.ALL a lista de plataformas é salva assim que salvamos um Game,  
de forma "cascateada".  
Para Salvarmos um Game precisamos informas os valores necessarios nos inputs e adicionar em um lista separada as plataformas, ou seja, digitamos uma plataformas e clicamos em "+",  
digitamos outra e clicamos novamente em "+", e será percebido que uma outra lista é iterada logo abaixo só com as plataformas, após isso é só persistir clicando no botão "Cadastrar",  
termos todas as plataformas listadas salvas e vinculadas ao ID do game, e clicando na **Lupa** poderemos ver o "Resumo" onde é possivel filtrar um resultado e até mesmo ver as plataformas setadas  
anteriormente, tudo isso atravéz do **Dialog FrameWork** do **Primefaces**.



► Qualquer dúvida é só me entrar em contato via E-Mail **delsonsaint@hotmail.com** .  



           
           
                       
