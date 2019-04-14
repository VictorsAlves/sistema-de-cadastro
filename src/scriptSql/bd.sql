create table cliente (
idcliente integer not null  auto_increment,
nome varchar (255) not null,
sobrenome varchar(255) not null, 
cpf varchar (255) not null,
datanascimento date,
genero varchar (255) not null,
rua varchar (255) not null,
numero varchar (255) not null,
bairro varchar (255) not null,
estado varchar (255) not null,
cidade varchar (255) not null,
cep varchar (255) not null,
constraint pk_id_cliente primary key (idcliente)
);


create table produto(
cod_produto integer not null auto_increment,
nomeproduto varchar(255) not null,
descricao varchar(255) not null,
marca varchar (255) not null,
categoria varchar(255) not null,
composicao varchar (255) not null,
dimensoes varchar (255) not null,
quantidade integer  not null,
preco double not null,
constraint pk_produto primary key (cod_produto)
);

create table itensVenda(
cod_item integer not null auto_increment,
codProd integer,
quantidade integer not null,
preco double ,
constraint pk_itemVenda primary key (cod_item),
foreign key (codProd) references produto (cod_produto)
);

create table venda(
numNota integer not null auto_increment,
datavenda date not null,
cnpj varchar (255),
valortotal double not null,
cod_cliente integer,
cod_item integer,
primary key (numNota),
foreign key (cod_cliente) references cliente (idcliente),
foreign key (cod_item) references itensVenda (cod_item)

);









