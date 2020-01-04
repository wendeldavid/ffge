<template>
<div class="status">
      <p>
        <label>Estamos trabalhando </label>
        <label class="number">{{portal.days}}</label>
        <label> sem ser grosso e escroto.</label>
      </p>
      <p>
        <label>Nosso recorde é de</label>
        <label class="number">{{portal.record}}</label>
        <label>dias. Colabore para melhorar este índice.</label>
      </p>

      <b-list-group>
        <b-list-group-item href="#" class="flex-column align-items-start" v-for="grosseria in grosserias" v-bind:key="grosseria.id">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Foi {{grosseria.acao}} com <b>{{grosseria.vitima}}</b></h5>
            <small>{{grosseria.data.date.day}}/{{grosseria.data.date.month}}/{{grosseria.data.date.year}} - {{grosseria.data.time.hour}}:{{grosseria.data.time.minute}}</small>
          </div>

          <blockquote class="quote">
            {{grosseria.descricao}}
          </blockquote>

          <small v-bind:class="{ 'd-none': !grosseria.replica }"><b>Réplica:</b> {{grosseria.replica}}</small>
        </b-list-group-item>
      </b-list-group>
  </div>
</template>

<script>

import Vue from 'vue';
import firebase from 'firebase';
import VueMoment from 'vue-moment';
import moment from 'moment-timezone';
 
Vue.use(VueMoment, {
    moment
});

moment.locale('pt-BR');

export default {
    name: 'portal',
    data() {
        let database = firebase.database();

        let data = database.ref().child('/grosserias/');
        
        data.once('value').then(function(snapshot) {
            snapshot.val();
            
        });

        let grosserias = [ {
    "acao" : "escroto",
    "data" : {
      "date" : {
        "day" : 14,
        "month" : 7,
        "year" : 2016
      },
      "time" : {
        "hour" : 0,
        "minute" : 0,
        "nano" : 0,
        "second" : 0
      }
    },
    "fulikes" : {
      "-LNDPjQc4eeeB61bxMoj" : {
        "a" : "A"
      },
      "a" : "a",
      "groserias" : [ {
        "fulikes" : {
          "-LNDRD-1LDBh3UrbMM2x" : {
            "a" : "a"
          }
        }
      } ]
    },
    "hide" : false,
    "id" : 0,
    "vitima" : "Thomas"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 25,
        "month" : 7,
        "year" : 2016
      },
      "time" : {
        "hour" : 14,
        "minute" : 17,
        "nano" : 182000000,
        "second" : 5
      }
    },
    "descricao" : "falando que o Denner se veste igual a ele no estilo \"Sid Life Style = mulambo sujo\". Uma grosseria e escrotice dupla da parte dele.",
    "hide" : false,
    "id" : 1,
    "vitima" : "Sid"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 25,
        "month" : 7,
        "year" : 2016
      },
      "time" : {
        "hour" : 15,
        "minute" : 11,
        "nano" : 357000000,
        "second" : 16
      }
    },
    "descricao" : "Falando que o Denner se veste no estilo Sid Life Style. É uma dupla escrotisse, pois o Denner não estava presente no momento (escrotisse pelas costas 2x)",
    "hide" : false,
    "id" : 2,
    "vitima" : "Denner"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 29,
        "month" : 7,
        "year" : 2016
      },
      "time" : {
        "hour" : 12,
        "minute" : 36,
        "nano" : 361000000,
        "second" : 21
      }
    },
    "descricao" : "Afirmou que a menina faz serviço de presidiário que os caras são loucos incluindo ela. Porém em suas falas ele usou palavras de baixo calão que tenho vergonha de incluir aqui nessa descrição.",
    "hide" : false,
    "id" : 3,
    "vitima" : "Uma menina"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 29,
        "month" : 7,
        "year" : 2016
      },
      "time" : {
        "hour" : 12,
        "minute" : 37,
        "nano" : 925000000,
        "second" : 47
      }
    },
    "descricao" : "Comparou o Jordan com um cosplay de indiano genérico qualquer que faz comedia em seriados.",
    "hide" : false,
    "id" : 4,
    "likes" : [ "169.254.51.114", "10.1.26.33", "10.1.27.4", "10.1.26.175", "10.1.26.56" ],
    "vitima" : "Jordan"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 29,
        "month" : 7,
        "year" : 2016
      },
      "time" : {
        "hour" : 12,
        "minute" : 40,
        "nano" : 276000000,
        "second" : 55
      }
    },
    "descricao" : "Não quis patrocinar a cuca por conseguir bater o seu próprio recorde de 8 dias.",
    "hide" : false,
    "id" : 5,
    "vitima" : "Cuca Manager"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 29,
        "month" : 7,
        "year" : 2016
      },
      "time" : {
        "hour" : 12,
        "minute" : 42,
        "nano" : 621000000,
        "second" : 7
      }
    },
    "descricao" : "Ficou ofendido com o xingamento do Sid",
    "hide" : false,
    "id" : 6,
    "vitima" : "Wallace"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 29,
        "month" : 7,
        "year" : 2016
      },
      "time" : {
        "hour" : 12,
        "minute" : 42,
        "nano" : 589000000,
        "second" : 38
      }
    },
    "descricao" : "Me mandou tomar no c*",
    "hide" : false,
    "id" : 7,
    "vitima" : "Sid"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 29,
        "month" : 7,
        "year" : 2016
      },
      "time" : {
        "hour" : 12,
        "minute" : 42,
        "nano" : 293000000,
        "second" : 57
      }
    },
    "descricao" : "Chamou o Parode de burro por tabela",
    "hide" : false,
    "id" : 8,
    "vitima" : "Parode"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 2,
        "month" : 8,
        "year" : 2016
      },
      "time" : {
        "hour" : 11,
        "minute" : 35,
        "nano" : 610000000,
        "second" : 51
      }
    },
    "descricao" : "Perguntei ao FF sobre o almoço de hoje, ele disse que não tinha horário pois tem membros do almoço no páginas do futuro, logo em seguida me enviou uma mensagem que achei escrotisse da parte dele, \"mas eu te aviso pelo whats, 5 minutos depois de sairmos\". A prova está em \\\\pcbnu009335\\public\\escrotisse.jpg ",
    "hide" : false,
    "id" : 9,
    "likes" : [ "10.1.26.175" ],
    "replica" : "Não acho válido o relato do Candinho como escrotice por 2 motivos:\n1.\tO teor da mensagem de avisar 5 minutos depois de sair, é uma piada interna do grupo de almoço. Não caracterizando assim ofensa ou exclusão do Candinho do almoço;\n2.\tEnviei a mensagem incentivado pelo Wendel, que inclusive foi quem criou a piada de não esperar o Candinho. Notem que parece ser uma situação meio premeditada, pois o Wendel sugeriu a brincadeira, sendo ele quem manda a URL do portal para cadastro da \"escrotisse\" que ele mesmo criou.",
    "vitima" : "Jair"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 2,
        "month" : 8,
        "year" : 2016
      },
      "time" : {
        "hour" : 13,
        "minute" : 37,
        "nano" : 588000000,
        "second" : 3
      }
    },
    "descricao" : "Ofensor foi grosso e escroto na réplica insinuando que eu premeditei tudo, o que não há prova nenhuma disto. Além de tentar denegrir minha imagem sem provas está tentando gerar discórdia pois eu apenas respondi a url que foi solicitado pelo candinho, e isto não configura crime.",
    "hide" : false,
    "id" : 10,
    "vitima" : "Wendel"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 3,
        "month" : 8,
        "year" : 2016
      },
      "time" : {
        "hour" : 12,
        "minute" : 44,
        "nano" : 465000000,
        "second" : 33
      }
    },
    "descricao" : "Mandou todos enrolarem o portal e atochar ele no c*",
    "hide" : false,
    "id" : 11,
    "vitima" : "todos"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 8,
        "month" : 8,
        "year" : 2016
      },
      "time" : {
        "hour" : 12,
        "minute" : 45,
        "nano" : 294000000,
        "second" : 0
      }
    },
    "descricao" : "Numa conversa sobre olimpiadas ele retruca um comentário simples com: \"QUE CROSSFIT? CALA BOCA!!!!\"",
    "hide" : false,
    "id" : 12,
    "vitima" : "Fabricio"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 12,
        "month" : 8,
        "year" : 2016
      },
      "time" : {
        "hour" : 16,
        "minute" : 56,
        "nano" : 680000000,
        "second" : 34
      }
    },
    "descricao" : "Mono disse que  trocou de lugar para focar no projeto e que aqui tem o pessoal legal para conversar, ai o João disse: \"Mas o montanha não votou em mim para destaque, ele não conta como pessoa legal\"",
    "hide" : false,
    "id" : 13,
    "vitima" : "Montanha"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 16,
        "month" : 8,
        "year" : 2016
      },
      "time" : {
        "hour" : 15,
        "minute" : 36,
        "nano" : 442000000,
        "second" : 43
      }
    },
    "descricao" : "Foi grosseiro reclamando que agora tem gente sentando na frente dele e foi escroto dando um chutão no meu pé machucado por baixo da mesa",
    "hide" : false,
    "id" : 14,
    "vitima" : "Suzane"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 20,
        "month" : 8,
        "year" : 2016
      },
      "time" : {
        "hour" : 17,
        "minute" : 59,
        "nano" : 546000000,
        "second" : 37
      }
    },
    "descricao" : "Ao questionar a demora do Fala Fina para largar as coisas e ir embora fui atacado com um sonoro \"VAI SE F...\", onde o agressor se aproveitou do fato de ser sábado para falar mais alto ainda que o normal.",
    "hide" : false,
    "id" : 15,
    "likes" : [ "10.1.27.4", "192.168.56.101" ],
    "vitima" : "Fabricio"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 24,
        "month" : 8,
        "year" : 2016
      },
      "time" : {
        "hour" : 13,
        "minute" : 42,
        "nano" : 720000000,
        "second" : 30
      }
    },
    "descricao" : "Reincidente. De forma indireta, associou que o Jordan teria amizade com um indiano genérico que almoçava no Restaurante 25. Mesmo ciente de que não há nenhum parentesco, com nenhuma pessoa de origem indiana, árabe ou afins, continua a fazer este tipo de associação.",
    "hide" : false,
    "id" : 16,
    "likes" : [ "10.1.26.49", "169.254.51.114", "10.1.26.33", "10.1.27.89", "10.1.27.4", "192.168.56.101", "10.1.26.56" ],
    "vitima" : "Jordan Laus"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 25,
        "month" : 8,
        "year" : 2016
      },
      "time" : {
        "hour" : 14,
        "minute" : 41,
        "nano" : 211000000,
        "second" : 37
      }
    },
    "descricao" : "Re-Reincidente. Hoje, o Fala Fina foi grosseiro ao me cumprimentar com um \"Namastê\" (com as mãos juntas), e mais tarde falou que eu não poderia pegar o Pokémon Taurus, porque na �?ndia a vaca é sagrada.",
    "hide" : false,
    "id" : 17,
    "likes" : [ "169.254.51.114", "10.1.26.33", "192.168.56.101" ],
    "vitima" : "Jordan Laus"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 30,
        "month" : 8,
        "year" : 2016
      },
      "time" : {
        "hour" : 13,
        "minute" : 34,
        "nano" : 731000000,
        "second" : 25
      }
    },
    "descricao" : "\"Atar band enfia no C#!!\"",
    "hide" : false,
    "id" : 18,
    "likes" : [ "10.1.28.192" ],
    "vitima" : "Atar band e Presente de final do ano"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 13,
        "month" : 9,
        "year" : 2016
      },
      "time" : {
        "hour" : 9,
        "minute" : 0,
        "nano" : 975000000,
        "second" : 18
      }
    },
    "descricao" : "Fala fina chega para trabalhar, olha para a minha cara e diz que já teve mais medo da minha cara de psicopata, mas que ainda acha minha cara como a de um psicopata",
    "hide" : false,
    "id" : 19,
    "likes" : [ "10.1.26.175", "10.1.28.192" ],
    "replica" : "\\\\seniorpdc\\Usuarios\\Joaom\\replicaMontanha.jpg",
    "vitima" : "Montanha"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 20,
        "month" : 9,
        "year" : 2016
      },
      "time" : {
        "hour" : 18,
        "minute" : 5,
        "nano" : 76000000,
        "second" : 55
      }
    },
    "descricao" : "Após apontar para o Fala Fina onde fica o menu do LDAP no Artifactory ele me mandou tomar no c*. Depois ele ficou resmungando outras coisa, porém eu consegui ouvir claramente ele sendo grosseiro.",
    "hide" : false,
    "id" : 20,
    "vitima" : "Sid"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 21,
        "month" : 9,
        "year" : 2016
      },
      "time" : {
        "hour" : 10,
        "minute" : 0,
        "nano" : 608000000,
        "second" : 10
      }
    },
    "descricao" : "Eu disse que o dia estava lindo e queria aproveitar, quando o Fala Fina me mandou fazer concurso para gari :'(",
    "hide" : false,
    "id" : 21,
    "likes" : [ "10.1.28.192" ],
    "vitima" : "Marina Uliano"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 21,
        "month" : 9,
        "year" : 2016
      },
      "time" : {
        "hour" : 10,
        "minute" : 10,
        "nano" : 576000000,
        "second" : 24
      }
    },
    "descricao" : "Após o cadastro da Marina o Fala Fina olho pra mim e falou: \"É bem assim que eu falei, aham!\", insinuando que ela mentiu.",
    "hide" : false,
    "id" : 22,
    "vitima" : "Marina"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 21,
        "month" : 9,
        "year" : 2016
      },
      "time" : {
        "hour" : 10,
        "minute" : 17,
        "nano" : 774000000,
        "second" : 50
      }
    },
    "descricao" : "Fala Fina, está lendo todos os cadastros do portal e falou de boca cheia: \"São uns cretinos!!!\".",
    "hide" : false,
    "id" : 23,
    "vitima" : "Todas as pessoas do portal"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 27,
        "month" : 9,
        "year" : 2016
      },
      "time" : {
        "hour" : 13,
        "minute" : 13,
        "nano" : 679000000,
        "second" : 21
      }
    },
    "descricao" : "Falei para o Fala Fina, não seja tão grosso com o Wallace. Ele olhou para mim e disse \"quem te nomeou Conselho Tutelar?, crio minhas crianças como eu quiser\".",
    "hide" : false,
    "id" : 24,
    "vitima" : "Sid"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 6,
        "month" : 10,
        "year" : 2016
      },
      "time" : {
        "hour" : 17,
        "minute" : 36,
        "nano" : 306000000,
        "second" : 0
      }
    },
    "descricao" : "A Luciana passou na minha mesa e perguntou \"O que você fez com a barba Sid?\". Falei para ela, cortei para ser mais simpático. Assim que terminei minha resposta o Fala Fina olhou pra mim e disse: \"Nem nascendo de novo!!!\"",
    "hide" : false,
    "id" : 25,
    "likes" : [ "10.1.26.49" ],
    "vitima" : "Sid"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 21,
        "month" : 10,
        "year" : 2016
      },
      "time" : {
        "hour" : 12,
        "minute" : 29,
        "nano" : 489000000,
        "second" : 10
      }
    },
    "descricao" : "Por um motivo fútil ele disse \"vai se f...\", e ao perceber que quebrou o recorde de 14 dias desferiu em meu ombro 3 golpes de guarda-chuva.\nPara completar deu um quarto golpe no mesmo ombro (esquerdo) dizendo \"e agora no direito então\" (?!?)",
    "hide" : false,
    "id" : 26,
    "vitima" : "Fabricio"
  }, {
    "acao" : "Grosseiro e Escroto e Sádico",
    "data" : {
      "date" : {
        "day" : 21,
        "month" : 10,
        "year" : 2016
      },
      "time" : {
        "hour" : 12,
        "minute" : 54,
        "nano" : 693000000,
        "second" : 46
      }
    },
    "descricao" : "Eu estava há uma semana praticando os ensinamentos do novo Fala Fina para me tornar uma pessoa melhor e só porque falei algo (não direcionado a ninguém) que ele achou ofensivo, prontamente levantou-se da cadeira e começou a me agredir verbalmente, com frases como: \"VIU COMO EU ME SINTO QUANDO QUEBRO MEU RECORDE?? É BOM NÉ? T�? VENDO?\" E mesmo vendo que eu estava visivelmente triste e abalada com minha perda, ele continuou por um longo tempo apontando o dedo para mim, rindo alto e se divertindo com a dor e derrota alheia.",
    "hide" : false,
    "id" : 27,
    "vitima" : "Suzane"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 21,
        "month" : 10,
        "year" : 2016
      },
      "time" : {
        "hour" : 13,
        "minute" : 5,
        "nano" : 825000000,
        "second" : 20
      }
    },
    "descricao" : "Software que é bom nessa empresa nada, agora o portal (ffge) sempre com novidades.",
    "hide" : false,
    "id" : 28,
    "vitima" : "Todos"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 21,
        "month" : 10,
        "year" : 2016
      },
      "time" : {
        "hour" : 13,
        "minute" : 7,
        "nano" : 704000000,
        "second" : 34
      }
    },
    "descricao" : "Escrotizou o estilo de futebol",
    "hide" : false,
    "id" : 29,
    "vitima" : "Tarcisio"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 21,
        "month" : 10,
        "year" : 2016
      },
      "time" : {
        "hour" : 13,
        "minute" : 9,
        "nano" : 21000000,
        "second" : 12
      }
    },
    "descricao" : "Fala fina está fazendo pouco do pessoal que cadastra as ofensas no portal, dizendo que vai pedir pro Administrador do portal colocar ao final de todas reclamações tbm que ele puxou o cabelo e jogou uma pedra. Ou seja, está dizendo que todo mundo aqui exagera e mente sobre os atos dele.",
    "hide" : false,
    "id" : 30,
    "vitima" : "Todos do portal"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 21,
        "month" : 10,
        "year" : 2016
      },
      "time" : {
        "hour" : 13,
        "minute" : 11,
        "nano" : 927000000,
        "second" : 16
      }
    },
    "descricao" : "Ele cadastrou uma issue irrelevante satirizando de forma escrota a ferramenta e sua intenção de melhorar o ambiente de trabalho",
    "hide" : false,
    "id" : 31,
    "vitima" : "Administradores do portal"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 21,
        "month" : 10,
        "year" : 2016
      },
      "time" : {
        "hour" : 13,
        "minute" : 11,
        "nano" : 250000000,
        "second" : 39
      }
    },
    "descricao" : "Não contente em afirmar que todos estão mentindo no portal, criou uma issue para comprovar a grosseira",
    "hide" : false,
    "id" : 32,
    "vitima" : "Todos"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 21,
        "month" : 10,
        "year" : 2016
      },
      "time" : {
        "hour" : 13,
        "minute" : 31,
        "nano" : 843000000,
        "second" : 30
      }
    },
    "descricao" : "Para o Fala Fina, tudo cadastrado aqui no portal é choradeira",
    "hide" : false,
    "id" : 33,
    "vitima" : "Todos do portal"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 21,
        "month" : 10,
        "year" : 2016
      },
      "time" : {
        "hour" : 13,
        "minute" : 35,
        "nano" : 750000000,
        "second" : 51
      }
    },
    "descricao" : "Insinuando que eu era a pessoa que estava realizando os cadastros das ofensas, uma acusação feita de forma arbitrária e sem qualquer meio concreto de comprovação, apenas porque eu estava distraído ele disse que estava \"disfarçando\".",
    "hide" : false,
    "id" : 34,
    "vitima" : "Montanha"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 1,
        "month" : 11,
        "year" : 2016
      },
      "time" : {
        "hour" : 14,
        "minute" : 45,
        "nano" : 488000000,
        "second" : 48
      }
    },
    "descricao" : "O Fala Fina fez uma prestação de serviço para o suporte e recebeu um feedback, \"Você é nosso herói\". Após esse momento caloroso no seu coração, ele olhou para os lados e falou, \"Chupa Portal, pode fazer o que quiser, eu sou um herói\"",
    "hide" : false,
    "id" : 35,
    "likes" : [ "10.1.26.49" ],
    "vitima" : "Portal"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 1,
        "month" : 11,
        "year" : 2016
      },
      "time" : {
        "hour" : 15,
        "minute" : 5,
        "nano" : 777000000,
        "second" : 47
      }
    },
    "descricao" : "Wallace estava cadastrando nova evidência no Portal ffge quando o João aperta o botão \"Esc\" a fim de praticar um desserviço.",
    "hide" : false,
    "id" : 36,
    "vitima" : "Wallace (o novo Cuca Manager)"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 4,
        "month" : 11,
        "year" : 2016
      },
      "time" : {
        "hour" : 10,
        "minute" : 30,
        "nano" : 252000000,
        "second" : 26
      }
    },
    "descricao" : "Além de ser timboense, não tem divulgado o portal para seus colegas, o que demonstra um certo descaso com os tão nobres colegas que criaram essa maravilhosa ferramenta, que pode ajudar o Falafina a ser uma pessoa melhor.",
    "hide" : false,
    "id" : 37,
    "vitima" : "Augusto"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 10,
        "month" : 11,
        "year" : 2016
      },
      "time" : {
        "hour" : 13,
        "minute" : 21,
        "nano" : 357000000,
        "second" : 46
      }
    },
    "descricao" : "Falei com carinho, \"foi o gordinho\". Ele olhou pra mim depois de 10 minutos e disse: \"Gordinho é a mãe\" (e outras palavras de baixo calão).",
    "hide" : false,
    "id" : 38,
    "vitima" : "emanuel"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 18,
        "month" : 11,
        "year" : 2016
      },
      "time" : {
        "hour" : 12,
        "minute" : 56,
        "nano" : 468000000,
        "second" : 54
      }
    },
    "descricao" : "Enquanto eu fingia que chutava a cadeira do Sidnei, o Fala Fina falou que eu não deveria fazer isso, porque na \"religião indiana\" isso não se faz. Infelizmente, ele continua insistindo com este tipo de associação.",
    "hide" : false,
    "id" : 39,
    "likes" : [ "10.1.26.49", "169.254.51.114", "10.1.26.33" ],
    "replica" : "Protesto contra o cadastro.\nMotivo: Caducou a reclamação após 24 horas.",
    "vitima" : "Jordan"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 8,
        "month" : 12,
        "year" : 2016
      },
      "time" : {
        "hour" : 13,
        "minute" : 25,
        "nano" : 296000000,
        "second" : 47
      }
    },
    "descricao" : "FIcou fazendo chacota que foi comprar uma bicicleta de rodinha pq com 50 anos de idade ainda não sabia andar de bicicleta",
    "hide" : false,
    "id" : 40,
    "likes" : [ "10.1.26.49" ],
    "vitima" : "Mono"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 13,
        "month" : 12,
        "year" : 2016
      },
      "time" : {
        "hour" : 15,
        "minute" : 19,
        "nano" : 32000000,
        "second" : 15
      }
    },
    "descricao" : "Na reunião do Acesso-CM-EF, comentaram que devemos cadastrar sugestões de presente no site para o Amigo Cachaceiro.\nFala Fina de modo desagradável:  \"Por isso não participo do amigo secreto, é só para se  i n c o m o d a r !!\"",
    "hide" : false,
    "id" : 41,
    "vitima" : "turma do \"Amigo Cachaceiro\" do Acesso"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 14,
        "month" : 12,
        "year" : 2016
      },
      "time" : {
        "hour" : 15,
        "minute" : 22,
        "nano" : 519000000,
        "second" : 56
      }
    },
    "descricao" : "Após o Fala Fina usar de sua grosseria costumeira e quebrar uma cadeira com toda a sua \"delicadeza\" aqui no terceiro andar, cheguei perto dele para ver se estava machucado e prontamente chamar um brigadista, porém ele tentou me agredir com os restos mortais da pobre cadeira. :(",
    "hide" : false,
    "id" : 42,
    "vitima" : "Sid"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 14,
        "month" : 12,
        "year" : 2016
      },
      "time" : {
        "hour" : 15,
        "minute" : 38,
        "nano" : 829000000,
        "second" : 53
      }
    },
    "descricao" : "Num ataque de fúria durante um apoio a equipe do SystemTeam, o Fala Fina depredou o patrimônio da empresa quebrando a cadeira em que se sentava. Possui um agravante ainda por se tratar de um ser inanimado, portante sem chance de pronta defesa.",
    "hide" : false,
    "id" : 43,
    "likes" : [ "10.1.26.175", "10.1.26.33" ],
    "vitima" : "Cadeira"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 15,
        "month" : 12,
        "year" : 2016
      },
      "time" : {
        "hour" : 13,
        "minute" : 45,
        "nano" : 36000000,
        "second" : 19
      }
    },
    "descricao" : "Na festa de encerramento do acesso, fui atingido por uma cabeçada do Fala Fina. Acredito que foi uma imitação grosseira do Zidane.",
    "hide" : false,
    "id" : 44,
    "vitima" : "Zidane"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 16,
        "month" : 12,
        "year" : 2016
      },
      "time" : {
        "hour" : 13,
        "minute" : 46,
        "nano" : 74000000,
        "second" : 32
      }
    },
    "descricao" : "Palavras do Fala Fina: \"Esse pessoal de Itajaí não pode ver uma faquinha, que já quer limpar um peixinho.\" Isto mostra a falta de \"desrespeito\" quanto aos Itajaienses. Na próxima vez, a \"faquinha\" vai no bucho!",
    "hide" : false,
    "id" : 45,
    "likes" : [ "169.254.51.114", "10.1.26.33" ],
    "vitima" : "Jordan"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 16,
        "month" : 12,
        "year" : 2016
      },
      "time" : {
        "hour" : 14,
        "minute" : 2,
        "nano" : 769000000,
        "second" : 57
      }
    },
    "descricao" : "Ao auxiliar o mono com seus apontamentos de hora, ofendeu o sistema diversas vezes, até perceber que o erro era de apontamento dele mesmo.",
    "hide" : false,
    "id" : 46,
    "vitima" : "BI"
  }, {
    "data" : {
      "date" : {
        "day" : 9,
        "month" : 1,
        "year" : 2017
      },
      "time" : {
        "hour" : 14,
        "minute" : 2,
        "nano" : 769000000,
        "second" : 57
      }
    },
    "hide" : true,
    "id" : 47
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 10,
        "month" : 1,
        "year" : 2017
      },
      "time" : {
        "hour" : 15,
        "minute" : 37,
        "nano" : 854000000,
        "second" : 54
      }
    },
    "descricao" : "Fala Fina mandou uma mensagem para mim ir até a máquina dele, e quando cheguei ele estava na ilha do café. Me deu tchauzinho e tudo tirando onda da minha cara.",
    "hide" : false,
    "id" : 48,
    "vitima" : "Raquel Raduenz"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 18,
        "month" : 1,
        "year" : 2017
      },
      "time" : {
        "hour" : 9,
        "minute" : 46,
        "nano" : 236000000,
        "second" : 48
      }
    },
    "descricao" : "Fala fina reagiu com indiferença e muita covardia ao ser indagado sobre uma reunião de sexta feira, e se poderia dar um auxilio a um colaborador em seu horário de trabalho, por sua vez o colaborar disse que sabe onde seus pais moram em timbo, fala fina reagiu estranhamente se ausentando da conversa.",
    "hide" : false,
    "id" : 49,
    "likes" : [ "10.1.40.131" ],
    "vitima" : "Lindsey"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 18,
        "month" : 1,
        "year" : 2017
      },
      "time" : {
        "hour" : 15,
        "minute" : 16,
        "nano" : 881000000,
        "second" : 39
      }
    },
    "descricao" : "Raquel foi ao 3º andar dar parabéns ao Wallace e perguntando onde estavam os balões da decoração achando que era seu aniversário, pois olhou o Portal DHO \"por cima\" e não reparou que é na verdade, 1 ano de Senior.\nFala Fina não se controlou e soltou o julgamento cruel: \"Esse é tipo de gente que faz a documentação dos sistemas da Senior\" ou algo parecido com isso, exagerando na reação pela falta de atenção da colega.",
    "hide" : false,
    "id" : 50,
    "likes" : [ "10.1.40.131" ],
    "vitima" : "Raquel"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 26,
        "month" : 1,
        "year" : 2017
      },
      "time" : {
        "hour" : 8,
        "minute" : 6,
        "nano" : 394000000,
        "second" : 51
      }
    },
    "descricao" : "Ao me aproximar para parabenizar o Denner pelo seu bigode (cabron!). O Fala Fina desprezou meu comentário, gerando uma interpretação inexistente. Uma clara falta de simpatia por um colega elogiado em sua frente.",
    "hide" : false,
    "id" : 51,
    "likes" : [ "10.1.40.131", "10.1.44.216" ],
    "vitima" : "Bruno"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 26,
        "month" : 1,
        "year" : 2017
      },
      "time" : {
        "hour" : 12,
        "minute" : 33,
        "nano" : 498000000,
        "second" : 19
      }
    },
    "descricao" : "Falou que eu tinha cara de que numa vida passada vivi como viking, mas catando bosta de vaca",
    "hide" : false,
    "id" : 52,
    "likes" : [ "169.254.51.114", "10.1.26.49", "10.1.27.10", "10.1.26.33", "10.1.40.131", "10.1.44.216" ],
    "vitima" : "Wendel"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 26,
        "month" : 1,
        "year" : 2017
      },
      "time" : {
        "hour" : 13,
        "minute" : 26,
        "nano" : 341000000,
        "second" : 18
      }
    },
    "descricao" : "Hoje ao comentar, \"Fala Fina olha aqui os gráficos do dashboard, estão com valores diferentes, mas são os mesmo filtros, porque será?\".\n\nEle olha pra mim e diz. Claro, você esta usando os filtros de maneira errada, essa DICA vou deixar de graça hoje.",
    "hide" : false,
    "id" : 53,
    "likes" : [ "10.1.27.45", "10.1.27.74", "10.1.40.131", "10.1.44.216" ],
    "vitima" : "Sid"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 31,
        "month" : 1,
        "year" : 2017
      },
      "time" : {
        "hour" : 16,
        "minute" : 46,
        "nano" : 108000000,
        "second" : 17
      }
    },
    "descricao" : "Enquanto eu passava pelo Fala Fina, que estava cadastrando a sua nova foto do crachá e definindo a quantidade de \"X\" da sua camiseta. Do nada, sem motivo, sem razão ou circunstância começa a escrotidão gratuita e sem limites:  \"O Parode com essa cara de cera, nem precisa cadastrar foto, sempre tá igual em todas\".",
    "hide" : false,
    "id" : 54,
    "likes" : [ "10.1.28.170", "10.1.26.33", "10.1.40.131", "10.1.27.4", "10.1.44.216" ],
    "vitima" : "Parode"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 2,
        "month" : 2,
        "year" : 2017
      },
      "time" : {
        "hour" : 13,
        "minute" : 47,
        "nano" : 740000000,
        "second" : 51
      }
    },
    "descricao" : "(Grosseria) Em um único combo, deferiu uma sequência de xingamentos à minha pessoa. As palavras viado do caralho, pau no cu, vai tomar no teu cu e filho da puta foram usadas na ocasião. \n(Escrotisse) Após eu falar que me senti ofendido, ele falou que todos xingamentos foram merecidos.",
    "hide" : false,
    "id" : 55,
    "likes" : [ "10.1.26.49", "10.1.40.131", "10.1.44.216" ],
    "vitima" : "Denner"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 3,
        "month" : 2,
        "year" : 2017
      },
      "time" : {
        "hour" : 15,
        "minute" : 46,
        "nano" : 833000000,
        "second" : 39
      }
    },
    "descricao" : "Fui fazer uma brincadeira aqui com um amigo nosso e o cara foi escroto pois não entendeu a brincadeira e ainda me xingou...",
    "hide" : false,
    "id" : 56,
    "likes" : [ "10.1.26.173", "10.1.27.74", "10.1.40.131", "10.1.44.216", "10.1.27.10" ],
    "vitima" : "Murilo Helmbrecht"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 8,
        "month" : 2,
        "year" : 2017
      },
      "time" : {
        "hour" : 11,
        "minute" : 6,
        "nano" : 826000000,
        "second" : 38
      }
    },
    "descricao" : "Fala fina, durante sua \"análise\" do novo layout do 3º andar comenta: \"Pelo menos não vou ficar mais perto desse cadáver!\"",
    "hide" : false,
    "id" : 57,
    "likes" : [ "10.1.40.138", "10.1.26.173", "10.1.27.45", "10.1.28.170", "10.1.26.33", "10.1.40.131", "10.1.27.4", "10.1.44.216", "10.1.26.187", "10.1.26.175", "10.1.27.10", "10.1.26.107", "10.1.21.29" ],
    "vitima" : "Parode"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 10,
        "month" : 2,
        "year" : 2017
      },
      "time" : {
        "hour" : 16,
        "minute" : 46,
        "nano" : 241000000,
        "second" : 17
      }
    },
    "descricao" : "Cheguei perto do João para ajuda-lo com um problema de instabilidade no FTP e ele olhou pra mim e disse, \"vai tomar no c*\". Fiquei muito triste porque fui ajudar ele na minha maior inocência. :(",
    "hide" : false,
    "id" : 58,
    "likes" : [ "10.1.26.90", "10.1.26.49", "10.1.26.33", "10.1.26.175", "10.1.21.29", "10.1.27.30", "10.1.44.215" ],
    "vitima" : "Sid"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 13,
        "month" : 2,
        "year" : 2017
      },
      "time" : {
        "hour" : 13,
        "minute" : 41,
        "nano" : 3000000,
        "second" : 36
      }
    },
    "descricao" : "Eu estava na copa comentando como é triste ficar nas sinaleiras mendigando nesses tempos de chuva. Por que? Porque o pessoal nos carros não querem abrir a janela quando está chovendo. Todos na copa se comoveram,mas o nosso amigo Fala Fina, solta... \"Vão tudo tomar no c* esse mendigos, estão lá porque querem, bando de vadio\". Triste essa juventude atual.",
    "hide" : false,
    "id" : 59,
    "vitima" : "Sid e todos os mendigos do mundo"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 17,
        "month" : 2,
        "year" : 2017
      },
      "time" : {
        "hour" : 9,
        "minute" : 16,
        "nano" : 257000000,
        "second" : 40
      }
    },
    "descricao" : "Ao comentar com o querido colega de trabalho João que o Sid tinha me ajudado muito e por isso iria criar um feedback positivo para ele no HCM, ele me respondeu: \"Não preciso de feedback de café pequeno\".",
    "hide" : false,
    "id" : 60,
    "likes" : [ "10.1.44.215", "10.1.28.170" ],
    "vitima" : "Francielle Tontini Zimermann"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 21,
        "month" : 2,
        "year" : 2017
      },
      "time" : {
        "hour" : 10,
        "minute" : 50,
        "nano" : 148000000,
        "second" : 16
      }
    },
    "descricao" : "Ao comentarmos que nosso colega Sidnei está com pneumonia, João teceu um comentário similar à isso: \"Eu falei pra ele essa vida de mendigo pedindo dinheiro é assim. Pega muito sol e chuva.\"",
    "hide" : false,
    "id" : 61,
    "likes" : [ "169.254.51.114", "10.1.44.215" ],
    "vitima" : "Sid"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 1,
        "month" : 3,
        "year" : 2017
      },
      "time" : {
        "hour" : 13,
        "minute" : 38,
        "nano" : 1000000,
        "second" : 18
      }
    },
    "descricao" : "Ao comentar que o portal estava contando o feriado de carnaval, o Fala Fina comentou com um tom ironico. Se o portal tivesse optado por usar a \"tecnologia maravilhosa\" do Acesso para contar apenas dias úteis, tudo estaria Okay. #FFOF #FalaFinaOnFire",
    "hide" : false,
    "id" : 62,
    "likes" : [ "10.1.26.33", "192.168.56.101", "10.1.26.175" ],
    "vitima" : "Portal e Gestão de Acesso"
  }, {
    "acao" : "Grosseiro, Escroto e Antipático",
    "data" : {
      "date" : {
        "day" : 14,
        "month" : 3,
        "year" : 2017
      },
      "time" : {
        "hour" : 14,
        "minute" : 20,
        "nano" : 58000000,
        "second" : 59
      }
    },
    "descricao" : "Ao compartilhar uma matéria divertida e descontraída sobre pessoas que parecem ter cara de antipáticas, houveram colegas que disseram que eu não parecia. Mas o Fala Fina mesmo de férias em vez de curtir o momento com a esposa e ser uma pessoa mais alegre para o mundo na praia, prefere destilar ódio e comentar: \"Realmente, não tem a cara de antipático. E sim o kit completo\".",
    "hide" : false,
    "id" : 63,
    "likes" : [ "10.1.27.70", "10.1.21.29", "10.1.26.107", "10.1.26.175", "10.1.26.33", "10.1.44.245" ],
    "vitima" : "Sid"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 17,
        "month" : 3,
        "year" : 2017
      },
      "time" : {
        "hour" : 9,
        "minute" : 40,
        "nano" : 718000000,
        "second" : 6
      }
    },
    "descricao" : "Estava criando sinergia com a nova equipe de trabalho pelo whatsapp, compartilhando oportunidades de adquirir novos conhecimentos.  Então o FalaFina chega de manhã e antes mesmo de um cortêz \"Bom dia\", solta um \"PUXA-SACO!\"",
    "hide" : false,
    "id" : 64,
    "likes" : [ "10.1.26.49", "10.1.26.33", "10.1.26.175", "10.1.40.106", "10.1.28.170", "10.1.26.173", "10.1.44.245" ],
    "replica" : "Na verdade eu falei, \"TU É UM PUTA PUXA-SACO DO CARALHO\"",
    "vitima" : "Parode"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 27,
        "month" : 3,
        "year" : 2017
      },
      "time" : {
        "hour" : 15,
        "minute" : 48,
        "nano" : 638000000,
        "second" : 59
      }
    },
    "descricao" : "Escrotisse Remota.\nMesmo em Ribeirão Preto, 894Km de Blumenau, foi escroto comigo.\nEm uma conferência com o FalaFina e Sid, onde eu por ventura cantei, Fala fina comentou que é melhor ouvir o coelho do Sid berrar.",
    "hide" : false,
    "id" : 65,
    "likes" : [ "10.1.26.175" ],
    "vitima" : "Denner Floriani"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 6,
        "month" : 4,
        "year" : 2017
      },
      "time" : {
        "hour" : 16,
        "minute" : 40,
        "nano" : 7000000,
        "second" : 15
      }
    },
    "descricao" : "Sid e ff sairam pra trabalhar em outra cidade. Porém pela ansiedade de fazer um bom trabalho, sid esqueceu o carregador no notebook. Somado ao translado pela violência das rodovias brasieliras, e como se não fosse suficiente ele ainda solta: \"Parabéns, entrasse pro time do wendel que leva o xbox mas não a fonte, PARABÉNS!\" Isso foi uma escrotisse muito gratuita.",
    "hide" : false,
    "id" : 66,
    "likes" : [ "10.1.26.173", "10.1.44.245", "10.1.26.175", "10.1.28.66" ],
    "vitima" : "Sid"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 12,
        "month" : 4,
        "year" : 2017
      },
      "time" : {
        "hour" : 16,
        "minute" : 51,
        "nano" : 956000000,
        "second" : 45
      }
    },
    "descricao" : "O Wallace comentou entre a equipe, acho que o Fala Fina até o final do ano bate o recorde no portal. Após o comentário o Fala Fina solta, não adianta, quando chegar perto do recorde o Mendigo aqui do lado (Sid) cadastra qualquer coisa, insinuando que eu sou um mentiroso e trapaceiro. Obs.: Hoje o contador estava em 6 dias sem grosserias, sendo que o recorde é 20 dias.",
    "hide" : false,
    "id" : 67,
    "likes" : [ "10.1.26.175" ],
    "vitima" : "Sid"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 4,
        "month" : 5,
        "year" : 2017
      },
      "time" : {
        "hour" : 14,
        "minute" : 31,
        "nano" : 105000000,
        "second" : 19
      }
    },
    "descricao" : "João chutou minha cadeira, na frente dos meus colegas de trabalho, por causa do atendimento do chamado 1834269, que sequer foi realizado por minha pessoa.",
    "hide" : false,
    "id" : 68,
    "likes" : [ "10.1.23.8" ],
    "vitima" : "Denner Floriani"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 4,
        "month" : 5,
        "year" : 2017
      },
      "time" : {
        "hour" : 18,
        "minute" : 7,
        "nano" : 937000000,
        "second" : 1
      }
    },
    "descricao" : "Me deu um soco.",
    "hide" : false,
    "id" : 69,
    "vitima" : "Gabriel Quintino"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 5,
        "month" : 5,
        "year" : 2017
      },
      "time" : {
        "hour" : 15,
        "minute" : 53,
        "nano" : 535000000,
        "second" : 59
      }
    },
    "descricao" : "Levei um soco na costela, duas tentativas de joelhadas na perna, e fui ameaçado, já que ia cadastrar novamente.",
    "hide" : false,
    "id" : 70,
    "likes" : [ "10.1.27.7" ],
    "vitima" : "Gabriel Quintino"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 10,
        "month" : 5,
        "year" : 2017
      },
      "time" : {
        "hour" : 14,
        "minute" : 57,
        "nano" : 32000000,
        "second" : 54
      }
    },
    "descricao" : "Após a equipe declarar que o Fala Fina é uma pessoa fofa e querida, não mais aquele cara nervoso. Ele olhou bem friamente para todos e disse, \"preciso ganhar insalubridade, eu não aguento mais vocês\" e se debruçou na mesa com cara de desgosto. Essas atitudes acabam com a sinergia da equipe.",
    "hide" : false,
    "id" : 71,
    "likes" : [ "10.1.27.7", "169.254.68.220", "10.1.26.173" ],
    "vitima" : "Colegas da equipe do fala fina"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 12,
        "month" : 5,
        "year" : 2017
      },
      "time" : {
        "hour" : 17,
        "minute" : 7,
        "nano" : 879000000,
        "second" : 48
      }
    },
    "descricao" : "Ao ser questionado de forma amigável e educada se era responsável por determinada funcionalidade do GitLab, respondeu \"não clico em nenhum link que tu mandar\" gratuitamente.",
    "hide" : false,
    "id" : 72,
    "likes" : [ "10.1.26.131" ],
    "vitima" : "João Paulo Gonçalves Brandt"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 30,
        "month" : 5,
        "year" : 2017
      },
      "time" : {
        "hour" : 16,
        "minute" : 38,
        "nano" : 311000000,
        "second" : 58
      }
    },
    "descricao" : "Ao comentar que o Simon é muito parecido com o Gerhard, tipo pai e filho. O fala fina solta: \"O capeta usou duas vezes a forma da desgraça.\"",
    "hide" : false,
    "id" : 73,
    "likes" : [ "10.1.26.92", "10.1.26.173", "10.1.40.124", "10.1.44.159" ],
    "vitima" : "Simon e Gerhard"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 23,
        "month" : 6,
        "year" : 2017
      },
      "time" : {
        "hour" : 13,
        "minute" : 37,
        "nano" : 618000000,
        "second" : 43
      }
    },
    "descricao" : "Na hora de ir almoçar não encontrei meu colega Fala Fina em sua mesa, e ao ir no banheiro me deparei com o rapaz. Perguntei \"ah, aí está você, finalmente\". Ele respondeu \"Teu c* \".\nNo momento que falei \"Isto vale um cadastro no portal\" ele retrucou \"Vale é eu enfiar tua cara na poça de mijo\"\nTudo isto pois havia passado 6 minutos da hora habitual de almoçar.",
    "hide" : false,
    "id" : 74,
    "likes" : [ "10.1.26.65", "10.1.27.6" ],
    "vitima" : "Fabricio"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 23,
        "month" : 6,
        "year" : 2017
      },
      "time" : {
        "hour" : 13,
        "minute" : 51,
        "nano" : 550000000,
        "second" : 54
      }
    },
    "descricao" : "Fiquei ofendido/estarrecido pelo fato de um colega de trabalho utilizar-se de uma linguagem tão chula para ofender outro colega.\n\n\"Vale é eu enfiar tua cara na poça de mijo\": acho que nem estivadores dos portos mais imundos utilizaram tal expressão.",
    "hide" : false,
    "id" : 75,
    "likes" : [ "10.1.26.65" ],
    "vitima" : "João Paulo Gonçalves Brandt"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 28,
        "month" : 6,
        "year" : 2017
      },
      "time" : {
        "hour" : 11,
        "minute" : 14,
        "nano" : 103000000,
        "second" : 58
      }
    },
    "descricao" : "João me chamou enquanto eu passava no corredor e eu pedi que esperasse 1 minuto. Ao retornar (em menos de 1 minuto até), fui gentilmente até nosso colega perguntar o que ele precisava. Cheguei e fui recebido com a grosseria: \"Não quero mais falar contigo, vou falar com o RESPONSÁVEL.\" A ênfase no responsável foi escrotisse.",
    "hide" : false,
    "id" : 76,
    "likes" : [ "10.1.27.6", "10.1.27.74", "10.1.44.159" ],
    "vitima" : "Denner Floriani"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 30,
        "month" : 6,
        "year" : 2017
      },
      "time" : {
        "hour" : 13,
        "minute" : 33,
        "nano" : 411000000,
        "second" : 18
      }
    },
    "descricao" : "Hoje de manhã de maneira surpeendente o falafina me chamou para almoçar junto. Achei estranho pois ele tem os colegas dele no almoço. \n\nMas logo topei pois somos amigos desde a infância e trabalhamos junto por volta de 10 anos. Eis que ele então mostra o real motivo: havia esquecido a carteira e os colegas dele já tinham compromisso. \n\nComo se não bastasse, depois ele veio novamente falar me dizendo que iria cancelar o almoço comigo porquê os amigos dele cancelaram seus compromissos e assim ele iria voltar a pedir almoço pago para eles. \n\nO que parecia um momento de relembrar os velhos tempos resultou em eu ser descartado antes mesmo de ser usado.",
    "hide" : false,
    "id" : 77,
    "likes" : [ "10.1.27.74", "10.1.29.94", "10.1.44.159", "10.1.27.6" ],
    "vitima" : "Matheus Klug"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 30,
        "month" : 6,
        "year" : 2017
      },
      "time" : {
        "hour" : 17,
        "minute" : 30,
        "nano" : 835000000,
        "second" : 30
      }
    },
    "descricao" : "Hoje ao lembrar que o Fala Fina esqueceu a carteira em casa pensei em fazer uma boa ação e pagar a cuca pra ele. \nAo falar para o Fala Fina que iria pagar e que ele nem precisava me devolver o dinheiro, recebi a seguinte ofensa para minha maior tristeza: \"Tu é um CRETINO\". \nÉ incrível como aluguém tem o sangue de barata de criticar a oferta recebida e ainda se aproveita sem ao menos agradecer.",
    "hide" : false,
    "id" : 78,
    "likes" : [ "10.1.44.159", "10.1.26.171", "10.1.26.59" ],
    "vitima" : "Sid"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 4,
        "month" : 7,
        "year" : 2017
      },
      "time" : {
        "hour" : 14,
        "minute" : 35,
        "nano" : 313000000,
        "second" : 7
      }
    },
    "descricao" : "Simon estava comendo uma tortuguita conforme o ritual (as patas primeiro).\nJoão, de uma forma escrotíssima falou que parecia um ritual satânico.\n\nAcho uma dupla escrotisse, sendo que o Simon não tem capacidade de se defender sozinho.",
    "hide" : false,
    "id" : 79,
    "likes" : [ "10.1.26.124", "10.1.27.84", "10.1.26.33" ],
    "vitima" : "Marcos \"Cadáver\" Simon"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 27,
        "month" : 7,
        "year" : 2017
      },
      "time" : {
        "hour" : 14,
        "minute" : 1,
        "nano" : 932000000,
        "second" : 30
      }
    },
    "descricao" : "A muitos anos atrás o Fala Fina comprou um apartamento na planta e até hoje o empreendimento não foi entregue. \n\nO Sid perguntou para o Fala Fina: \"Então esse apartamento nunca vai ficar pronto?\"\n\nO Fala Fina respondeu: \"Claro que vão entregar, vai ser entregue em Março de 2018.\"\n\nEu na maior inocência falei: \"que legal vai ter churrasco para comemorar!!!\"\n\nFala Fina olhou pra mim e falou: \"Churrasco é o teu C*******, nunca mais quero ver esse apartamento.\"",
    "hide" : false,
    "id" : 80,
    "likes" : [ "10.1.45.29", "10.1.26.65" ],
    "vitima" : "Marcos Simon"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 31,
        "month" : 7,
        "year" : 2017
      },
      "time" : {
        "hour" : 17,
        "minute" : 49,
        "nano" : 227000000,
        "second" : 54
      }
    },
    "descricao" : "Eu aqui conversando com o Sid sobre os problemas que estou enfrentando com o Delphi, falei como está feio essas implementações. Nesse momento o Fala Fina fala: \"Feio é tu se vendendo como programador Delphi e não consegue resolver os problemas.\" Me senti ofendido, não é fácil entender SVCL.",
    "hide" : false,
    "id" : 81,
    "likes" : [ "10.1.45.29" ],
    "vitima" : "Marcos Simon"
  }, {
    "acao" : "Grosseiro e Escroto",
    "data" : {
      "date" : {
        "day" : 22,
        "month" : 9,
        "year" : 2017
      },
      "time" : {
        "hour" : 8,
        "minute" : 17,
        "nano" : 250000000,
        "second" : 7
      }
    },
    "descricao" : "Pela manhã ao chegar na Senior, deparei-me com a iminente e trágica coincidência de ter que compartilhar o elevador com o Fala Fina. \nMesmo tentando dissimular para evitar a situação, fui impelido a entrar por pressão social (afinal, havia um espaço e as pessoas olhavam me aguardando).\n\nAo iniciar a viagem fatídica, Kremer, que também estava no elevador, questionou-me: \"Como está a Denise?\" (que é a minha esposa).\nNo que em um arrebatamento, sem pausa e descanso, surge a voz do fundo do elevador:\n\n\"Tirando o fato de que ela teve um filho do Paulog, deve estar bem né!\"\n\nSeguiu-se um silêncio constrangedor no ambiente. \n\nSó me restou sair cabisbaixo e pensar: \"Mais uma vítima! Até quando?\". Tão atormentado que fiquei por tal vilipêndio para com a minha pessoa, que até esqueci de marcar o ponto ao chegar.",
    "hide" : false,
    "id" : 82,
    "likes" : [ "169.254.229.92", "10.1.27.16", "10.1.29.130", "10.1.27.27", "10.1.27.12" ],
    "vitima" : "João Paulo Gonçalves Brandt"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 22,
        "month" : 9,
        "year" : 2017
      },
      "time" : {
        "hour" : 8,
        "minute" : 43,
        "nano" : 355000000,
        "second" : 6
      }
    },
    "descricao" : "Continuando com sua tarefa de obter cada vez mais pontos no Clube de Fidelidade da Escrotidão, FalaFina me \"parabenizou\" pelo relato anterior: \"parabéns! Se foi tu que escreveu\". Prova: http://pcbnu007999:8888/proof/ff_paulog_proof.png",
    "hide" : false,
    "id" : 83,
    "likes" : [ "10.1.27.27" ],
    "vitima" : "João Paulo Gonçalves Brandt"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 8,
        "month" : 12,
        "year" : 2017
      },
      "time" : {
        "hour" : 13,
        "minute" : 24,
        "nano" : 738000000,
        "second" : 7
      }
    },
    "descricao" : "Do nada o Fala Fina comentou que o sol hoje está \"quente\". Eu olhei pra ele e falei, a temperatura pode aumentar e baixar, porém o sol sempre está quente. O Fala Fina olhou pra mim e me chamou de haterzinho de merda e me mandou tomar no c*.",
    "hide" : false,
    "id" : 84,
    "likes" : [ "10.1.29.16", "10.1.26.224", "10.1.26.117", "10.1.26.216" ],
    "vitima" : "Janio Samuel Santana Junior"
  }, {
    "acao" : "Escroto",
    "data" : {
      "date" : {
        "day" : 2,
        "month" : 2,
        "year" : 2018
      },
      "time" : {
        "hour" : 17,
        "minute" : 7,
        "nano" : 993000000,
        "second" : 19
      }
    },
    "descricao" : "Houve uma brincadeira num grupo fechado do slack. Após o ocorrido o falafina, em um profundo sentimento de vingança, bloqueou meu usuário no Jira (uma ferramenta de trabalho usada diariamente) e trocou a foto do meu avatar por uma do Michel. Além de ser uma escrotisse me impedir de trabalhar, ainda envolve aquivos pessoais de terceiros que nada tem a ver com o ocorrido inicial. Dupla escrotisse da parte dele.",
    "hide" : false,
    "id" : 85,
    "likes" : [ "169.254.94.65", "10.1.27.126" ],
    "vitima" : "Wendel e Michel"
  }, {
    "acao" : "Grosseiro",
    "data" : {
      "date" : {
        "day" : 28,
        "month" : 2,
        "year" : 2018
      },
      "time" : {
        "hour" : 14,
        "minute" : 45,
        "nano" : 620000000,
        "second" : 12
      }
    },
    "descricao" : "Fala Fina \"esqueceu-se\" da etiqueta virtual ao utilizar @channel no canal #general do Slack. Desnecessário.",
    "hide" : false,
    "id" : 86,
    "likes" : [ "10.1.27.174", "10.1.27.126", "10.1.26.56" ],
    "vitima" : "Todo mundo no slack da Senior"
  } ];

        grosserias = grosserias.reverse();

        let last = grosserias[0];

        let countLast = moment([last.data.date.year, last.data.date.month, last.data.date.day]).fromNow();


        var record = 0;

        for (var i = 0; i < grosserias.length; i++) {
          if (i === grosserias.length - 1 || 
            !grosserias[0].data || !grosserias[0].data.date ||
            !grosserias[0 + 1].data || !grosserias[0 + 1].data.date) {
            break;
          }

          let grosseria = grosserias[i];
          let a = moment([grosseria.data.date.year, grosseria.data.date.month, grosseria.data.date.day]);

          let proximaProsseria = grosserias[i + 1];
          let b = moment([proximaProsseria.data.date.year, proximaProsseria.data.date.month, proximaProsseria.data.date.day]);

          let currentDiff = a.diff(b, 'days');

          if (currentDiff > record) { 
            record = currentDiff;
          }
        }

        return {
          portal: {
            days: countLast,
            record: record
          },
          grosserias : grosserias
        }
    }
}
</script>

<style scoped>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

.quote {
  position: relative;
  font-family: 'Sanchez', serif;
  font-size: 2em;
  line-height: 1.5em;
  padding: 0 10 0 10;
  margin: 0 10 0 10;
}
.quote:before {
    content: '\201C';
    position: absolute;
    top: 0.25em;
    left: 0em;
    font-size: 3em;
    z-index: -1;
  }
.quote:after {
    content: '\201D';
    position: absolute;
    bottom: 0em;
    right: 0;
    font-size: 3em;
    font-style: italic;
    z-index: -1;
  }

.portal.logo {
  padding: 50px;
}

.portal .status p {
  font-weight: bold;
  font-size: 20px;
}

.portal .number {
  color: red;
}

.portal .number:before {
  content: "\00a0";
}

.portal .number:after {
  content: "\00a0";
}

</style>