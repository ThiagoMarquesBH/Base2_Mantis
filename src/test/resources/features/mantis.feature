#language: pt
Funcionalidade: Rotina Mantins
  Como usuario eu quero acessar o Mantins, realizar um cadastro, editar esse cadastro e fechar esse cadastro

  Esquema do Cenario: Rotina Mantins
    Dados que faco o login com <usuario> e <senha>
    Quando acesso o <projeto>
    Entao reporto uma issue com <categoria>, <reprodutibilidade>, <severidade>, <prioridade>, <perfil>, <resumo> e <descricao>. listo todas as issues por id, acessando a ultima issue lancada verifico se foi a lancada.
    E na issue lancada adiciona uma <nota> e verifico a nota lancada

    Exemplos: 
      | usuario          | senha           | projeto                    | categoria              | reprodutibilidade | severidade | prioridade | perfil                | resumo               | descricao            | nota                 |
      | "thiago.marques" | "ThiagoMarques" | "Thiago Marques´s Project" | "[All Projects] Teste" | "always"          | "trivial"  | "normal"   | "Desktop  Windows 10" | "Teste automatizado" | "Automação de teste" | "Nota via automação" |
