### Checklist:


- [ ] Adicionar "foods" no ambiente;
- [ ] Desenvolver UML e definir projeto no quadro
- [ ] Finalizar Classe Ator.java
- [ ] Escrever Classe Sistema.java
- [ ] Criar arquivo de documentação
- [ ] Arquivos (.png, ícones) para interface 
- [x] Organizar Visualmente o arquivo README.md
- [x] Criar Arquivo TODO
- [x] Criar Classe Rand.java

---------------------
PACOTES:
---------------------    
* classfiles      // classes principais
* classinterfaces // interfaces das classes
* conection       // conexão BD
* controllers     // controladores UI (User Interface)
* imagefiles      // arquivos de imagem
* mainpackage     // pacote principal
* view            // .css .fxml

---------------------
CLASSES:
---------------------  

* Ambiente

- getCharAmbienteId()               byte  
- isAmbienteNatural(Ator)   boolean   
- boolean   isAtorInPos(x,y)- void  addAtor(Ator)
- void  removeAtor(Ator)
- checkEnergiaPorAmbiente(Ator)   void  
- void      setChar(char, x, y)
- char  getChar(x,y)

* Sistema.SistemaLocomotor

- moverEsquerda()
- moverDireita()

---------------------    
Sobre Desenvolvimento de Games:
---------------------    

- inicialização

gameloop() {
    while(true) {

    
    }

}    

