<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/metune.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>${Soforca}</title>
</head>

<body>
    <header class="header">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <img class="navbar-brand" src="images/logometune.jpeg" alt="Logo do site">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNav" aria-controls="navbarNav"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                           
                            <a class="nav-link active" aria-current="page" href="#lancamentos">Lançamentos</a>
                        </li>
                        <li class="nav-item">
                            
                            <a class="nav-link" href="#destaques">Em destaque</a>
                        </li>
                        <li class="nav-item">
                         
                            <a class="nav-link" href="#avaliacoes">Avaliações</a>
                        </li>
                        <li class="nav-item">
                     
                            <a class="nav-link" href="#entrevistas">Musicas</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Buscar musica"
                            aria-label="Search">
                        <button class="btn btn-outline-light" type="submit">Buscar</button>
                    </form>
                </div>
            </div>
        </nav>
    </header>

    <main>
        
        <div class="container main">
            <h2 class="lancamentos" id="lancamentos">Lançamentos</h2>
        </div>
        <div class="container">
            <div class="row">
                <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                            class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3"
                            aria-label="Slide 4"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="4"
                            aria-label="Slide 5"></button>
                    </div>

                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="row" style="margin-bottom: 35px;">
                                <div class="col-xs-12 col-12 col-md-6" style="min-height: 294px;">
                                    <iframe width="522" height="380" src="https://www.youtube.com/embed/ieAUlb9spk8" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>  
                                </div>
                                <div class="col-xs-12 col-12 col-md-6">
                                    <p1 height="100% ">
                                        <!-- musica 1 -->
                                    </p1>
                                    <p></p>
                                    <div class="row ">
                                        <div class="col-xs-12 col-sm-12 col-md-3 col-lg-4">
                                            Thiago e Graciano - Terceiro Sofrendo Ft. Tierry | DVD Onda De Amor
                                        </div>

                                        <div class="col-xs-12 col-sm-12 col-md-3 col-lg-4">
                                            Letra: Ela não gosta de se prender
                                            Mas vai te prender
                                            Quando você ver já era
                                            Tô falando isso porque já passei sufoco na mão dela
                                            
                                            Ela me pegou e pegou você
                                            Mas fez direitinho pra nenhum dos dois saber
                                            Ela fez amor, amor sem sentimento
                                            Enganou você, enganou eu ao mesmo tempo
                                         </div>

                                        <div class="col-xs-12 col-sm-12 col-md-3 col-lg-4">
                                            Cantores:  Thiago e Graciano
                                        </div>
                                    </div>

                                    <div class="col-12"><br>
                                        Estreia: 25 de Agosto de 2022
                                    </div>

                                    <div class="col-12">
                                        Avaliação: Eu não esperava algo tão bom, chorei muito escutando.
                                    </div>

                                </div>
                            </div>
                        </div>

                        <!--musica 2-->

                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h2 class="destaques" id="destaques">Em destaque</h2>
                </div>
                <div class="col-6">
                    <div class="dropdown" style="text-align: right;">
                        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            Categoria: Edição
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <li><a class="dropdown-item" href="#">Adele</a></li>
                            <li><a class="dropdown-item" href="#">Adele</a></li>
                            <li><a class="dropdown-item" href="#">Adele</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-3">
                    <div class="card" widht="100%">
                        <img src="images/adele.jpg" class="card-img-top" alt="musica1">
                        <div class="card-body">
                            <p class="card-text"><b></b></p>
                        </div>
                    </div>
                </div>
                <div class="col-3">
                    <div class="card" widht="100%">
                        <img src="images/adele.jpg" class="card-img-top" alt="musica1">
                        <div class="card-body">
                            <p class="card-text"><b></b></p>
                        </div>
                    </div>
                </div>
                <div class="col-3">
                    <div class="card" widht="100%">
                        <img src="images/adele.jpg" class="card-img-top" alt="musica1">
                        <div class="card-body">
                            <p class="card-text"><b></b></p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="container" style="text-align: right; margin-top: 10px;">
            <div class="row">
                <div class="col-12">
                    <button type="button" class="btn btn-secondary btn-sm">Mais opções</button>
                </div>
            </div>
        </div>

    
        <div class="container">
            <h2 class="avaliacoes" id="avaliacoes">Últimas avaliações</h2>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-4">
                    <div class="container">
                        <div class="row">
                            <div class="col-3">
                                <div class="profile-header-container">
                                    <img class="img-circle" src="images/casamento-kauan-capa.jpg" height="100%" width="100%" />
                                </div>
                            </div>
                            <div class="col-9">
                                <h6>Andreia Santos</h6>
                                <p><b>Avaliação:</b> Eu ameeeei s2</p>
                                <p>★★★☆☆ - 02/04/2022</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="container">
                        <div class="row">
                            <div class="col-3">
                                <div class="profile-header-container">
                                    <img class="img-circle" src="images/casamento-kauan-capa.jpg" height="100%" width="100%" />
                                </div>
                            </div>
                            <div class="col-9">
                                <h6>Gabriel Luiz</h6>
                                <p><b>Avaliação:</b> Esperava mais.</p>
                                <p>★★★★★ - 12/01/2022</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="container">
                        <div class="row">
                            <div class="col-3">
                                <div class="profile-header-container">
                                    <img class="img-circle" src="images/casamento-kauan-capa.jpg" height="100%" width="100%" />
                                </div>
                            </div>
                            <div class="col-9">
                                <h6>Luiza Amaral</h6>
                                <p><b>Avaliação:</b> Não existe nada melhor.</p>
                                <p>★★★★☆ - 26/04/2022</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container" style="text-align: right; margin-top: 10px;">
            <div class="row">
                <div class="col-12">
                    <button type="button" class="btn btn-secondary btn-sm">Mais Opções</button>
                </div>
            </div>
        </div>

        <div class="container">
            <h2 class="entrevistas" id="entrevistas">Musicas</h2>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-4">
                    <iframe width="322" height="180" src="https://www.youtube.com/embed/tQ0yjYUFKAE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div>
                <div class="col-4">
                    <iframe width="322" height="180" src="https://www.youtube.com/embed/EDwb9jOVRtU" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div>
                <div class="col-4">
                    <iframe width="322" height="180" src="https://www.youtube.com/embed/NKzd_YiW9AQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-4">
                    <p><b>Musica:</b>Peaches<br>
                        <b>Diretor:</b>Justin Bieber.<br>
                        <b>Estreia:</b> 2013
                    </p>
                </div>
                <div class="col-4">
                    <p><b>Musica:</b> Hung Up.<br>
                        <b>Diretor:</b>Madonna.<br>
                        <b>Estreia:</b> 2014
                    </p>
                    </p>
                </div>
                <div class="col-4">
                    <p><b>Musica:</b>What If I Told You That I Love You.<br>
                        <b>Diretor:</b>Ali Gatie.<br>
                        <b>Estreia:</b> 2015
                    </p>
                </div>
            </div>
        </div>
        <div class="container" style="text-align: right; margin-top: 10px;">
            <div class="row">
                <div class="col-12">
                    <button type="button" class="btn btn-secondary btn-sm"> Mais opções</button>
                </div>
            </div>
        </div>

    </main>

    <!-- footer -->
    <footer>
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            <p class="footertext"> Trabalho Interdisciplinar II: Bancos de Dados e Sistemas Inteligentes
                <b>ICEI PUC MINAS</b>
            </p>
        <div class="card-panel card_social">
            <h5>Redes Sociais</h5>
            <ul class="list_redes_sociais">
              <li>
                <a
                  href="https://pt-br.facebook.com/netflixespana/"
                  targe="_blank"
                  >
                  <svg xmlns="http://www.w3.org/2000/svg" width="44" height="44" viewBox="0 0 44 44"><defs><style>.awe{fill:#0086d8;}.bdg{fill:#fff;}</style></defs><g transform="translate(-424 -4728)"><circle class="awe" cx="22" cy="22" r="22" transform="translate(424 4728)"/><path class="bdg" d="M14.094,21.583V12.14H18.14l.674-4.047H14.094V6.07a1.789,1.789,0,0,1,2.023-2.023H18.14V0H14.768C11.4,0,10.047,2.023,10.047,5.4v2.7H6V12.14h4.047v9.443Z" transform="translate(432 4739)"/></g></svg>
                </a>
              </li>
              <li>
                <a href="https://twitter.com/netflixes" targe="_blank"
                  >
                  <svg xmlns="http://www.w3.org/2000/svg" width="44" height="44" viewBox="0 0 44 44"><defs><style>.apo{fill:#0086d8;}.bbh{fill:#fff;}</style></defs><g transform="translate(-480 -4728)"><circle class="apo" cx="22" cy="22" r="22" transform="translate(480 4728)"/><path class="bbh" d="M20.595,52.728c.015.2.015.408.015.612A13.293,13.293,0,0,1,7.224,66.725,13.294,13.294,0,0,1,0,64.613a9.731,9.731,0,0,0,1.136.058,9.422,9.422,0,0,0,5.84-2.01,4.713,4.713,0,0,1-4.4-3.263,5.932,5.932,0,0,0,.888.073,4.975,4.975,0,0,0,1.238-.16A4.705,4.705,0,0,1,.932,54.694v-.058a4.738,4.738,0,0,0,2.126.6A4.711,4.711,0,0,1,1.6,48.941a13.372,13.372,0,0,0,9.7,4.923,5.311,5.311,0,0,1-.117-1.078,4.709,4.709,0,0,1,8.142-3.219,9.262,9.262,0,0,0,2.986-1.136,4.692,4.692,0,0,1-2.068,2.593,9.431,9.431,0,0,0,2.709-.728A10.113,10.113,0,0,1,20.595,52.728Z" transform="translate(490.658 4693.077)"/></g></svg>
                </a>
              </li>
              <li>
                <a
                  href="https://www.instagram.com/netflixes/" targe="_blank"
                  >
                  <svg xmlns="http://www.w3.org/2000/svg" width="44" height="44" viewBox="0 0 44 44">
                    <g id="Grupo_333" data-name="Grupo 333" transform="translate(-537 -4728)">
                      <circle id="Elipse_19" data-name="Elipse 19" cx="22" cy="22" r="22" transform="translate(537 4728)" fill="#0086d8"/>
                      <path id="instagram" d="M11.929,37.671a6.153,6.153,0,1,0,6.153,6.153A6.143,6.143,0,0,0,11.929,37.671Zm0,10.153a4,4,0,1,1,4-4,4.007,4.007,0,0,1-4,4Zm7.839-10.4a1.435,1.435,0,1,1-1.435-1.435A1.432,1.432,0,0,1,19.769,37.419Zm4.075,1.457a7.1,7.1,0,0,0-1.938-5.028,7.149,7.149,0,0,0-5.028-1.938c-1.981-.112-7.92-.112-9.9,0a7.138,7.138,0,0,0-5.028,1.933A7.125,7.125,0,0,0,.009,38.871c-.112,1.981-.112,7.92,0,9.9A7.1,7.1,0,0,0,1.948,53.8a7.158,7.158,0,0,0,5.028,1.938c1.981.112,7.92.112,9.9,0A7.1,7.1,0,0,0,21.905,53.8a7.149,7.149,0,0,0,1.938-5.028C23.956,46.79,23.956,40.857,23.844,38.876ZM21.284,50.9A4.05,4.05,0,0,1,19,53.179c-1.58.627-5.328.482-7.074.482s-5.5.139-7.074-.482A4.05,4.05,0,0,1,2.574,50.9c-.627-1.58-.482-5.328-.482-7.074s-.139-5.5.482-7.074a4.05,4.05,0,0,1,2.281-2.281c1.58-.627,5.328-.482,7.074-.482s5.5-.139,7.074.482a4.05,4.05,0,0,1,2.281,2.281c.627,1.58.482,5.328.482,7.074S21.911,49.323,21.284,50.9Z" transform="translate(547.073 4706.177)" fill="#fff"/>
                    </g>
                  </svg>
                </a>
              </li>
              <li>
                <a href="https://www.youtube.com/watch?v=NKzd_YiW9AQ" targe="_blank"
                  >
                  <svg xmlns="http://www.w3.org/2000/svg" width="44" height="44" viewBox="0 0 44 44"><defs><style>.uy{fill:#0086d8;}.io{fill:#fff;}</style></defs><g transform="translate(0 -552.362)"><rect class="uy" width="44" height="44" rx="22" transform="translate(0 552.362)"/><path class="io" d="M101.962,682.312s-5.024,0-8.373.266a3.258,3.258,0,0,0-2.4,1.116,6.064,6.064,0,0,0-.95,2.615S90,688.443,90,690.575v2c0,2.134.239,4.264.239,4.264a6.046,6.046,0,0,0,.95,2.615,3.852,3.852,0,0,0,2.641,1.127c1.915.2,8.138.264,8.138.264s5.031-.009,8.381-.274a3.27,3.27,0,0,0,2.4-1.116,6.05,6.05,0,0,0,.948-2.617s.241-2.131.241-4.264v-2c0-2.133-.241-4.267-.241-4.267a6.041,6.041,0,0,0-.948-2.615,3.26,3.26,0,0,0-2.4-1.116c-3.35-.268-8.373-.266-8.373-.266Zm-2.983,4.632,7.485,4.634-7.485,4.634v-9.268Z" transform="translate(-79.97 -117.218)"/></g></svg>
                </a>
              </li>
            </ul>
          </div>
        <div class="text_apps">
            <div class="title">
              <span>Chegou o site Me Tune :)</span>
            </div>
            <div class="subtitle">
              <span>Novidades e praticidade </span>
            </div>
            <div class="imgs_store">
              <div class="google_play">
                <a id="google-play" href="https://play.google.com/store/apps/details?id=com.netflix.mediaclient&hl=pt&gl=US">
                  <svg width="142" height="42" viewBox="0 0 142 42" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M21 31V11L38 21L21 31Z" stroke="#003A74" stroke-width="2" stroke-linejoin="round"/>
                    <path d="M21 12L33 24" stroke="#003A74" stroke-width="2"/>
                    <path d="M21 30L33 18" stroke="#003A74" stroke-width="2"/>
                    <rect x="1" y="1" width="140" height="40" rx="12" stroke="#003A74" stroke-width="2"/>
                    <path d="M57.7637 24.7422C57.3945 25.1842 56.8727 25.5283 56.1982 25.7744C55.5238 26.016 54.7764 26.1367 53.9561 26.1367C53.0947 26.1367 52.3382 25.9499 51.6865 25.5762C51.0394 25.1979 50.5381 24.651 50.1826 23.9355C49.8317 23.2201 49.6517 22.3792 49.6426 21.4131V20.7363C49.6426 19.7428 49.8089 18.8838 50.1416 18.1592C50.4788 17.43 50.9619 16.874 51.5908 16.4912C52.2243 16.1038 52.9648 15.9102 53.8125 15.9102C54.9928 15.9102 55.9157 16.1927 56.5811 16.7578C57.2464 17.3184 57.6406 18.1364 57.7637 19.2119H55.7676C55.6764 18.6423 55.4736 18.2253 55.1592 17.9609C54.8493 17.6966 54.4209 17.5645 53.874 17.5645C53.1768 17.5645 52.6458 17.8265 52.2812 18.3506C51.9167 18.8747 51.7321 19.654 51.7275 20.6885V21.3242C51.7275 22.3678 51.9258 23.1562 52.3223 23.6895C52.7188 24.2227 53.2998 24.4893 54.0654 24.4893C54.8356 24.4893 55.3848 24.3252 55.7129 23.9971V22.2812H53.8467V20.7705H57.7637V24.7422ZM58.9941 22.2334C58.9941 21.4997 59.1354 20.8457 59.418 20.2715C59.7005 19.6973 60.1061 19.2529 60.6348 18.9385C61.168 18.624 61.7855 18.4668 62.4873 18.4668C63.4854 18.4668 64.2988 18.7721 64.9277 19.3828C65.5612 19.9935 65.9144 20.8229 65.9873 21.8711L66.001 22.377C66.001 23.5117 65.6842 24.4232 65.0508 25.1113C64.4173 25.7949 63.5674 26.1367 62.501 26.1367C61.4346 26.1367 60.5824 25.7949 59.9443 25.1113C59.3109 24.4277 58.9941 23.498 58.9941 22.3223V22.2334ZM60.9697 22.377C60.9697 23.0788 61.1019 23.6165 61.3662 23.9902C61.6305 24.3594 62.0088 24.5439 62.501 24.5439C62.9795 24.5439 63.3532 24.3617 63.6221 23.9971C63.891 23.6279 64.0254 23.04 64.0254 22.2334C64.0254 21.5452 63.891 21.012 63.6221 20.6338C63.3532 20.2555 62.9749 20.0664 62.4873 20.0664C62.0042 20.0664 61.6305 20.2555 61.3662 20.6338C61.1019 21.0075 60.9697 21.5885 60.9697 22.377ZM66.9102 22.2334C66.9102 21.4997 67.0514 20.8457 67.334 20.2715C67.6165 19.6973 68.0221 19.2529 68.5508 18.9385C69.084 18.624 69.7015 18.4668 70.4033 18.4668C71.4014 18.4668 72.2148 18.7721 72.8438 19.3828C73.4772 19.9935 73.8304 20.8229 73.9033 21.8711L73.917 22.377C73.917 23.5117 73.6003 24.4232 72.9668 25.1113C72.3333 25.7949 71.4834 26.1367 70.417 26.1367C69.3506 26.1367 68.4984 25.7949 67.8604 25.1113C67.2269 24.4277 66.9102 23.498 66.9102 22.3223V22.2334ZM68.8857 22.377C68.8857 23.0788 69.0179 23.6165 69.2822 23.9902C69.5465 24.3594 69.9248 24.5439 70.417 24.5439C70.8955 24.5439 71.2692 24.3617 71.5381 23.9971C71.807 23.6279 71.9414 23.04 71.9414 22.2334C71.9414 21.5452 71.807 21.012 71.5381 20.6338C71.2692 20.2555 70.891 20.0664 70.4033 20.0664C69.9202 20.0664 69.5465 20.2555 69.2822 20.6338C69.0179 21.0075 68.8857 21.5885 68.8857 22.377ZM74.8467 22.2471C74.8467 21.1123 75.1156 20.1986 75.6533 19.5059C76.1956 18.8132 76.9248 18.4668 77.8408 18.4668C78.652 18.4668 79.2832 18.7448 79.7344 19.3008L79.8164 18.6035H81.6074V25.7539C81.6074 26.401 81.4593 26.9639 81.1631 27.4424C80.8714 27.9209 80.459 28.2855 79.9258 28.5361C79.3926 28.7868 78.7682 28.9121 78.0527 28.9121C77.5104 28.9121 76.9818 28.8027 76.4668 28.584C75.9518 28.3698 75.5622 28.0918 75.2979 27.75L76.1729 26.5469C76.665 27.0983 77.262 27.374 77.9639 27.374C78.488 27.374 78.8958 27.2327 79.1875 26.9502C79.4792 26.6722 79.625 26.2757 79.625 25.7607V25.3643C79.1693 25.8792 78.57 26.1367 77.8271 26.1367C76.9385 26.1367 76.2184 25.7904 75.667 25.0977C75.1201 24.4004 74.8467 23.4775 74.8467 22.3291V22.2471ZM76.8223 22.3906C76.8223 23.0605 76.9567 23.5869 77.2256 23.9697C77.4945 24.348 77.8636 24.5371 78.333 24.5371C78.9346 24.5371 79.3652 24.3115 79.625 23.8604V20.75C79.3607 20.2988 78.9346 20.0732 78.3467 20.0732C77.8727 20.0732 77.499 20.2669 77.2256 20.6543C76.9567 21.0417 76.8223 21.6204 76.8223 22.3906ZM85.2168 26H83.2344V15.5H85.2168V26ZM90.2549 26.1367C89.1702 26.1367 88.2861 25.804 87.6025 25.1387C86.9235 24.4733 86.584 23.5869 86.584 22.4795V22.2881C86.584 21.5452 86.7275 20.8822 87.0146 20.2988C87.3018 19.7109 87.7074 19.2598 88.2314 18.9453C88.7601 18.6263 89.3617 18.4668 90.0361 18.4668C91.0479 18.4668 91.8431 18.7858 92.4219 19.4238C93.0052 20.0618 93.2969 20.9665 93.2969 22.1377V22.9443H88.5869C88.6507 23.4274 88.8421 23.8148 89.1611 24.1064C89.4847 24.3981 89.8926 24.5439 90.3848 24.5439C91.1458 24.5439 91.7406 24.2682 92.1689 23.7168L93.1396 24.8037C92.8434 25.223 92.4424 25.5511 91.9365 25.7881C91.4307 26.0205 90.8701 26.1367 90.2549 26.1367ZM90.0293 20.0664C89.6374 20.0664 89.3184 20.1986 89.0723 20.4629C88.8307 20.7272 88.6758 21.1055 88.6074 21.5977H91.3555V21.4404C91.3464 21.0029 91.2279 20.6657 91 20.4287C90.7721 20.1872 90.4486 20.0664 90.0293 20.0664ZM100.092 22.4932V26H98.041V16.0469H101.924C102.671 16.0469 103.327 16.1836 103.893 16.457C104.462 16.7305 104.9 17.1201 105.205 17.626C105.51 18.1273 105.663 18.6992 105.663 19.3418C105.663 20.3171 105.328 21.0872 104.658 21.6523C103.993 22.2129 103.07 22.4932 101.89 22.4932H100.092ZM100.092 20.832H101.924C102.466 20.832 102.879 20.7044 103.161 20.4492C103.448 20.194 103.592 19.8294 103.592 19.3555C103.592 18.8678 103.448 18.4736 103.161 18.1729C102.874 17.8721 102.478 17.7171 101.972 17.708H100.092V20.832ZM109.033 26H107.051V15.5H109.033V26ZM114.953 26C114.862 25.8223 114.796 25.6012 114.755 25.3369C114.276 25.8701 113.654 26.1367 112.889 26.1367C112.164 26.1367 111.562 25.9271 111.084 25.5078C110.61 25.0885 110.373 24.5599 110.373 23.9219C110.373 23.138 110.662 22.5365 111.241 22.1172C111.825 21.6979 112.665 21.486 113.764 21.4814H114.673V21.0576C114.673 20.7158 114.584 20.4424 114.406 20.2373C114.233 20.0322 113.957 19.9297 113.579 19.9297C113.246 19.9297 112.984 20.0094 112.793 20.1689C112.606 20.3285 112.513 20.5472 112.513 20.8252H110.537C110.537 20.3968 110.669 20.0003 110.934 19.6357C111.198 19.2712 111.572 18.9863 112.055 18.7812C112.538 18.5716 113.08 18.4668 113.682 18.4668C114.593 18.4668 115.315 18.6969 115.849 19.1572C116.386 19.613 116.655 20.2555 116.655 21.085V24.291C116.66 24.9928 116.758 25.5238 116.949 25.8838V26H114.953ZM113.319 24.626C113.611 24.626 113.88 24.5622 114.126 24.4346C114.372 24.3024 114.554 24.127 114.673 23.9082V22.6367H113.935C112.946 22.6367 112.419 22.9785 112.355 23.6621L112.349 23.7783C112.349 24.0244 112.435 24.2272 112.608 24.3867C112.782 24.5462 113.019 24.626 113.319 24.626ZM120.825 23.2041L122.192 18.6035H124.312L121.338 27.1484L121.174 27.5381C120.732 28.5042 120.003 28.9873 118.986 28.9873C118.699 28.9873 118.408 28.944 118.111 28.8574V27.3604L118.412 27.3672C118.786 27.3672 119.064 27.3102 119.246 27.1963C119.433 27.0824 119.579 26.8932 119.684 26.6289L119.916 26.0205L117.325 18.6035H119.451L120.825 23.2041Z" fill="#003A74"/>
                    </svg>
                </a>
              </div>
              <div class="app_store">
                <a id="app-store" href="https://apps.apple.com/es/app/netflix/id363590051">
                  <svg width="142" height="42" viewBox="0 0 142 42" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M32.7763 11C32.822 11 32.8676 11 32.9159 11C33.0279 12.4104 32.4997 13.4643 31.8576 14.2275C31.2277 14.9854 30.365 15.7205 28.9698 15.609C28.8767 14.2187 29.4058 13.243 30.047 12.4816C30.6416 11.772 31.7318 11.1405 32.7763 11Z" fill="#003A74"/>
                    <path d="M37 25.6805C37 25.6946 37 25.7068 37 25.72C36.6079 26.9302 36.0486 27.9674 35.366 28.93C34.743 29.8038 33.9794 30.9798 32.6161 30.9798C31.438 30.9798 30.6555 30.2078 29.4481 30.1867C28.171 30.1656 27.4686 30.8322 26.3009 31C26.1673 31 26.0337 31 25.9027 31C25.0452 30.8735 24.3532 30.1815 23.8491 29.5579C22.3625 27.7154 21.2137 25.3354 21 22.2896C21 21.991 21 21.6933 21 21.3947C21.0905 19.2149 22.1298 17.4427 23.5113 16.5837C24.2403 16.1271 25.2426 15.738 26.3586 15.9119C26.8369 15.9874 27.3255 16.1543 27.7539 16.3194C28.1598 16.4784 28.6673 16.7603 29.1482 16.7453C29.474 16.7357 29.798 16.5627 30.1264 16.4406C31.0881 16.0867 32.0309 15.6809 33.2736 15.8715C34.7671 16.1016 35.8271 16.7778 36.4821 17.8212C35.2187 18.6406 34.2199 19.8754 34.3905 21.984C34.5422 23.8994 35.6349 25.0201 37 25.6805Z" fill="#003A74"/>
                    <rect x="1" y="1" width="140" height="40" rx="12" stroke="#003A74" stroke-width="2"/>
                    <path d="M55.5078 23.9492H51.9121L51.2285 26H49.0479L52.7529 16.0469H54.6533L58.3789 26H56.1982L55.5078 23.9492ZM52.4658 22.2881H54.9541L53.7031 18.5625L52.4658 22.2881ZM65.5088 22.3701C65.5088 23.5094 65.249 24.4232 64.7295 25.1113C64.2145 25.7949 63.5173 26.1367 62.6377 26.1367C61.8903 26.1367 61.2865 25.877 60.8262 25.3574V28.8438H58.8506V18.6035H60.6826L60.751 19.3281C61.2295 18.7539 61.8538 18.4668 62.624 18.4668C63.5355 18.4668 64.2441 18.804 64.75 19.4785C65.2559 20.153 65.5088 21.0827 65.5088 22.2676V22.3701ZM63.5332 22.2266C63.5332 21.5384 63.4102 21.0075 63.1641 20.6338C62.9225 20.2601 62.5693 20.0732 62.1045 20.0732C61.4847 20.0732 61.0586 20.3102 60.8262 20.7842V23.8125C61.0677 24.3001 61.4984 24.5439 62.1182 24.5439C63.0615 24.5439 63.5332 23.7715 63.5332 22.2266ZM73.3975 22.3701C73.3975 23.5094 73.1377 24.4232 72.6182 25.1113C72.1032 25.7949 71.4059 26.1367 70.5264 26.1367C69.779 26.1367 69.1751 25.877 68.7148 25.3574V28.8438H66.7393V18.6035H68.5713L68.6396 19.3281C69.1182 18.7539 69.7425 18.4668 70.5127 18.4668C71.4242 18.4668 72.1328 18.804 72.6387 19.4785C73.1445 20.153 73.3975 21.0827 73.3975 22.2676V22.3701ZM71.4219 22.2266C71.4219 21.5384 71.2988 21.0075 71.0527 20.6338C70.8112 20.2601 70.458 20.0732 69.9932 20.0732C69.3734 20.0732 68.9473 20.3102 68.7148 20.7842V23.8125C68.9564 24.3001 69.387 24.5439 70.0068 24.5439C70.9502 24.5439 71.4219 23.7715 71.4219 22.2266ZM83.4053 23.3887C83.4053 23.0013 83.2686 22.7051 82.9951 22.5C82.7217 22.2904 82.2295 22.0716 81.5186 21.8438C80.8076 21.6113 80.2448 21.3835 79.8301 21.1602C78.6999 20.5495 78.1348 19.7269 78.1348 18.6924C78.1348 18.1546 78.2852 17.6761 78.5859 17.2568C78.8913 16.833 79.3265 16.5026 79.8916 16.2656C80.4613 16.0286 81.0993 15.9102 81.8057 15.9102C82.5166 15.9102 83.1501 16.04 83.7061 16.2998C84.262 16.555 84.6927 16.9173 84.998 17.3867C85.3079 17.8561 85.4629 18.3893 85.4629 18.9863H83.4121C83.4121 18.5306 83.2686 18.1774 82.9814 17.9268C82.6943 17.6715 82.291 17.5439 81.7715 17.5439C81.2702 17.5439 80.8805 17.651 80.6025 17.8652C80.3245 18.0749 80.1855 18.3529 80.1855 18.6992C80.1855 19.0228 80.3473 19.2939 80.6709 19.5127C80.999 19.7314 81.4798 19.9365 82.1133 20.1279C83.2799 20.4788 84.1299 20.9141 84.6631 21.4336C85.1963 21.9531 85.4629 22.6003 85.4629 23.375C85.4629 24.2363 85.137 24.9131 84.4854 25.4053C83.8337 25.8929 82.9564 26.1367 81.8535 26.1367C81.0879 26.1367 80.3906 25.9977 79.7617 25.7197C79.1328 25.4372 78.652 25.0521 78.3193 24.5645C77.9912 24.0768 77.8271 23.5117 77.8271 22.8691H79.8848C79.8848 23.9674 80.541 24.5166 81.8535 24.5166C82.3411 24.5166 82.7217 24.4186 82.9951 24.2227C83.2686 24.0221 83.4053 23.7441 83.4053 23.3887ZM89.0928 16.7852V18.6035H90.3574V20.0527H89.0928V23.7441C89.0928 24.0176 89.1452 24.2135 89.25 24.332C89.3548 24.4505 89.5553 24.5098 89.8516 24.5098C90.0703 24.5098 90.264 24.4938 90.4326 24.4619V25.959C90.0452 26.0775 89.6465 26.1367 89.2363 26.1367C87.8509 26.1367 87.1445 25.4372 87.1172 24.0381V20.0527H86.0371V18.6035H87.1172V16.7852H89.0928ZM90.9453 22.2334C90.9453 21.4997 91.0866 20.8457 91.3691 20.2715C91.6517 19.6973 92.0573 19.2529 92.5859 18.9385C93.1191 18.624 93.7367 18.4668 94.4385 18.4668C95.4365 18.4668 96.25 18.7721 96.8789 19.3828C97.5124 19.9935 97.8656 20.8229 97.9385 21.8711L97.9521 22.377C97.9521 23.5117 97.6354 24.4232 97.002 25.1113C96.3685 25.7949 95.5186 26.1367 94.4521 26.1367C93.3857 26.1367 92.5335 25.7949 91.8955 25.1113C91.262 24.4277 90.9453 23.498 90.9453 22.3223V22.2334ZM92.9209 22.377C92.9209 23.0788 93.0531 23.6165 93.3174 23.9902C93.5817 24.3594 93.96 24.5439 94.4521 24.5439C94.9307 24.5439 95.3044 24.3617 95.5732 23.9971C95.8421 23.6279 95.9766 23.04 95.9766 22.2334C95.9766 21.5452 95.8421 21.012 95.5732 20.6338C95.3044 20.2555 94.9261 20.0664 94.4385 20.0664C93.9554 20.0664 93.5817 20.2555 93.3174 20.6338C93.0531 21.0075 92.9209 21.5885 92.9209 22.377ZM103.325 20.4561C103.056 20.4196 102.819 20.4014 102.614 20.4014C101.867 20.4014 101.377 20.6543 101.145 21.1602V26H99.1689V18.6035H101.035L101.09 19.4854C101.486 18.8063 102.035 18.4668 102.737 18.4668C102.956 18.4668 103.161 18.4964 103.353 18.5557L103.325 20.4561ZM107.55 26.1367C106.465 26.1367 105.581 25.804 104.897 25.1387C104.218 24.4733 103.879 23.5869 103.879 22.4795V22.2881C103.879 21.5452 104.022 20.8822 104.31 20.2988C104.597 19.7109 105.002 19.2598 105.526 18.9453C106.055 18.6263 106.657 18.4668 107.331 18.4668C108.343 18.4668 109.138 18.7858 109.717 19.4238C110.3 20.0618 110.592 20.9665 110.592 22.1377V22.9443H105.882C105.946 23.4274 106.137 23.8148 106.456 24.1064C106.78 24.3981 107.188 24.5439 107.68 24.5439C108.441 24.5439 109.035 24.2682 109.464 23.7168L110.435 24.8037C110.138 25.223 109.737 25.5511 109.231 25.7881C108.726 26.0205 108.165 26.1367 107.55 26.1367ZM107.324 20.0664C106.932 20.0664 106.613 20.1986 106.367 20.4629C106.126 20.7272 105.971 21.1055 105.902 21.5977H108.65V21.4404C108.641 21.0029 108.523 20.6657 108.295 20.4287C108.067 20.1872 107.743 20.0664 107.324 20.0664Z" fill="#003A74"/>
                    </svg>                            
                </a>
              </div>
            </div>
          </div>
     </div>   
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
</body>
</html>