import React from "react";

import "../assets/css/internas.css";

import Navbar from "./Navbar";
import Footer from "./Footer";

import ouroPreto1 from "../assets/img/destinations/ouro-preto/img1.jpg";
import ouroPreto2 from "../assets/img/destinations/ouro-preto/img2.jpg";
import ouroPreto3 from "../assets/img/destinations/ouro-preto/img3.jpg";
import profilePic from "../assets/img/profile_pic.jpg";

function Itinerary() {
  return (
    <>
      <Navbar />
      <div id="main">
        <div className="w-100 top-internas">
          <h3 className="text-center fw-bold">Pesquisa de roteiros</h3>
          <div className="d-flex justify-content-center">
            <nav aria-label="breadcrumb">
              <ol className="breadcrumb">
                <li className="breadcrumb-item">
                  <a href="/">Home</a>
                </li>
                <li className="breadcrumb-item active" aria-current="page">
                  Pesquisa de roteiros
                </li>
              </ol>
            </nav>
          </div>
        </div>

        <div className="container">
          <div className="row">
            <div className="col-md-12 col-sm-12">
              <div className="rounded-4 p-5 mb-5 destination-details">
                <h3 className="h3 fw-bold">Ouro Preto</h3>
                <p>Minas Gerais</p>

                <div className="row mb-4">
                  <div className="col-md-6">
                    <div
                      id="carousel-destination"
                      className="carousel slide"
                      data-bs-ride="carousel"
                    >
                      <div className="carousel-indicators">
                        <button
                          type="button"
                          data-bs-target="#carousel-destination"
                          data-bs-slide-to="0"
                          className="active"
                          aria-current="true"
                          aria-label="Slide 1"
                        ></button>
                        <button
                          type="button"
                          data-bs-target="#carousel-destination"
                          data-bs-slide-to="1"
                          aria-label="Slide 2"
                        ></button>
                        <button
                          type="button"
                          data-bs-target="#carousel-destination"
                          data-bs-slide-to="2"
                          aria-label="Slide 3"
                        ></button>
                      </div>
                      <div className="carousel-inner">
                        <div className="carousel-item active">
                          <img
                            src={ouroPreto1}
                            className="d-block w-100 rounded-4"
                            alt="Ouro Preto"
                          />
                        </div>
                        <div className="carousel-item">
                          <img
                            src={ouroPreto2}
                            className="d-block w-100 rounded-4"
                            alt="Ouro Preto"
                          />
                        </div>
                        <div className="carousel-item">
                          <img
                            src={ouroPreto3}
                            className="d-block w-100 rounded-4"
                            alt="Ouro Preto"
                          />
                        </div>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-6">
                    <iframe
                      src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d29918.370353159757!2d-43.50164564999999!3d-20.391287249999998!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xa40b1d2c57b55b%3A0xd984d1131d83d5fc!2sOuro%20Preto%2C%20MG%2C%2035400-000!5e0!3m2!1spt-PT!2sbr!4v1679627374114!5m2!1spt-PT!2sbr"
                      width="100%"
                      height="100%"
                      style={{border: "0"}}
                      allowfullscreen=""
                      loading="lazy"
                      referrerpolicy="no-referrer-when-downgrade"
                      className="rounded-4"
                    ></iframe>
                  </div>
                </div>

                <p>
                  Ouro Preto é uma das primeiras cidades tombadas pelo Iphan, em
                  1938, e a primeira cidade brasileira a receber o título de
                  Patrimônio Mundial, conferido pela Unesco, em 1980. Tal
                  reconhecimento deve-se, principalmente, ao fato da cidade ser
                  um sítio urbano completo e pouco alterado em relação à sua
                  essência: formação espontânea a partir de um sistema
                  minerador, seguido por uma marcada presença dos poderes
                  religioso e governamental, e fortes expressões artísticas que
                  se destacam por sua relevância internacional.{" "}
                </p>
                <p className="text-end">
                  <small>
                    Fonte: IPHAN
                    (http://portal.iphan.gov.br/pagina/detalhes/373/)
                  </small>
                </p>

                <p className="mb-5">
                  <span className="btn btn-light rounded-5">
                    <i className="bi bi-calendar3"></i> 2 dias
                  </span>{" "}
                  <span className="btn btn-light rounded-5">
                    <i className="bi bi-cash-coin ms-3"></i> A partir de{" "}
                    <strong>R$ 140,99</strong>
                  </span>
                </p>

                <a
                  href="#"
                  className="btn btn-warning rounded-pill me-2 ps-4 pe-4"
                >
                  Fazer reserva
                </a>
              </div>

              <div className="accordion mb-5 rounded-4" id="accordionExample">
                <div className="accordion-item">
                  <h2 className="accordion-header" id="headingOne">
                    <button
                      className="accordion-button"
                      type="button"
                      data-bs-toggle="collapse"
                      data-bs-target="#collapseOne"
                      aria-expanded="true"
                      aria-controls="collapseOne"
                    >
                      <i className="bi bi-calendar2-event me-2"></i> Quando ir?
                    </button>
                  </h2>
                  <div
                    id="collapseOne"
                    className="accordion-collapse collapse show"
                    aria-labelledby="headingOne"
                    data-bs-parent="#accordionExample"
                  >
                    <div className="accordion-body">
                      <p>
                        Ouro Preto é um cidade voltada para o turismo e durante
                        todo o ano recebe visitantes. Os fins de semana são
                        sempre mais disputados, especialmente pela presença dos
                        turistas de cidades próximas, que buscam viagens
                        rápidas. O mesmo acontece nos feriados e férias
                        escolares, que sempre atraem mais visitantes. Se você
                        deseja visitar a cidade com mais tranquilidade e sem
                        pagar muito caro pela hospedagem, o ideal é fugir dos
                        meses de dezembro, janeiro, fevereiro e julho, quando
                        Ouro Preto é tomada por turistas.
                      </p>

                      <p>
                        Entre os feriados que mais atraem visitantes para Ouro
                        Preto estão: o Carnaval, um dos eventos mais famosos de
                        Ouro Preto; a Semana Santa e o Corpus Cristhi, pelas
                        festividades religiosas; e o 12 de outubro, data na qual
                        é realizada a Festa do 12, onde ex-estudantes de Ouro
                        Preto retornam à cidade e às repúblicas para
                        comemorações. Sem esquecer, claro, do Natal e Ano Novo.
                        Em todos esses períodos, assim como nas férias
                        escolares, o preço das hospedagens sobe
                        consideravelmente e a viagem pode ficar bem mais cara.
                      </p>
                    </div>
                  </div>
                </div>
                <div className="accordion-item">
                  <h2 className="accordion-header" id="headingTwo">
                    <button
                      className="accordion-button collapsed"
                      type="button"
                      data-bs-toggle="collapse"
                      data-bs-target="#collapseTwo"
                      aria-expanded="false"
                      aria-controls="collapseTwo"
                    >
                      <i className="bi bi-compass me-2"></i> Como chegar?
                    </button>
                  </h2>
                  <div
                    id="collapseTwo"
                    className="accordion-collapse collapse"
                    aria-labelledby="headingTwo"
                    data-bs-parent="#accordionExample"
                  >
                    <div className="accordion-body">
                      <p>
                        A cidade de Ouro Preto está localizada no estado de
                        Minas Gerais, a apenas 100 km da capital Belo Horizonte.
                        Ouro Preto é um destino tranquilo de ser visitado, mesmo
                        para quem busca um passeio de apenas um dia. A partir de
                        BH, há várias opções de transportes e excursões para
                        Ouro Preto. Até mesmo táxi e Uber fazem o trajeto até a
                        cidade histórica. Por isso, não deixe de visitar Ouro
                        Preto, mesmo que seja para um bate e volta.
                      </p>

                      <p>
                        A principal porta de entrada para quem chega de outros
                        estados é o Aeroporto Internacional de Belo Horizonte -
                        Confins. Ele é o aeroporto mais próximo de Ouro Preto e
                        recebe voos de todas as regiões do Brasil. Não há
                        aeroportos em Ouro Preto. A partir de Confins, é
                        necessário escolher a melhor opção para ir até Ouro
                        Preto por via terrestre.
                      </p>
                    </div>
                  </div>
                </div>
                <div className="accordion-item">
                  <h2 className="accordion-header" id="headingThree">
                    <button
                      className="accordion-button collapsed"
                      type="button"
                      data-bs-toggle="collapse"
                      data-bs-target="#collapseThree"
                      aria-expanded="false"
                      aria-controls="collapseThree"
                    >
                      <i className="bi bi-pin-map me-2"></i> Onde ficar?
                    </button>
                  </h2>
                  <div
                    id="collapseThree"
                    className="accordion-collapse collapse"
                    aria-labelledby="headingThree"
                    data-bs-parent="#accordionExample"
                  >
                    <div className="accordion-body">
                      <p>
                        Os turistas que chegarem a Ouro Preto encontrarão muitas
                        opções de hospedagem para os dias de viagem. Há um
                        grande número de hotéis, pousadas e hostels que são
                        capazes de suprir bem a necessidade de todo tipo de
                        viajante. Os preços, no entanto, podem não agradar à
                        primeira vista. A cidade, totalmente voltada para o
                        turismo, costuma ter diárias bem salgadas, especialmente
                        nos fins de semana, feriados prolongados e férias
                        escolares. Por isso, se quiser viajar para Ouro Preto, é
                        recomendável se organizar com antecedência para não
                        pagar muito caro. Claro que também há opções mais
                        baratas, mas como resistir ao charme dos quartos nos
                        casarões coloniais ou com bela vista para as igrejas da
                        cidade? Se o dinheiro permitir, invista em hotéis que
                        oferecem um pouco da história de Ouro Preto aliados a
                        conforto e charme.{" "}
                      </p>
                    </div>
                  </div>
                </div>
                <div className="accordion-item">
                  <h2 className="accordion-header" id="headingFour">
                    <button
                      className="accordion-button collapsed"
                      type="button"
                      data-bs-toggle="collapse"
                      data-bs-target="#collapseFour"
                      aria-expanded="false"
                      aria-controls="collapseFour"
                    >
                      <i className="bi bi-shop me-2"></i> Onde comer?
                    </button>
                  </h2>
                  <div
                    id="collapseFour"
                    className="accordion-collapse collapse"
                    aria-labelledby="headingFour"
                    data-bs-parent="#accordionExample"
                  >
                    <div className="accordion-body">
                      <p>
                        A especialidade culinária de Ouro Preto não poderia ser
                        outra que não os maravilhosos temperos e sabores
                        mineiros. Há boa oferta de restaurantes que servem os
                        típicos lombo com tutu, frango com quiabo, costelinha,
                        feijão tropeiro e galinha ao molho pardo. Não será
                        difícil se deliciar entre a intensidade da comida
                        mineira. Os pratos típicos poderão ser degustados em
                        lanchonetes populares que servem PFs ou em restaurantes
                        mais refinados com cardápios que mesclam a culinária
                        mineira aos sabores internacionais. Os preços agradam a
                        todos os bolsos.
                      </p>
                    </div>
                  </div>
                </div>
                <div className="accordion-item">
                  <h2 className="accordion-header" id="headingFive">
                    <button
                      className="accordion-button collapsed"
                      type="button"
                      data-bs-toggle="collapse"
                      data-bs-target="#collapseFive"
                      aria-expanded="false"
                      aria-controls="collapseFive"
                    >
                      <i className="bi bi-ticket me-2"></i> O que fazer?
                    </button>
                  </h2>
                  <div
                    id="collapseFive"
                    className="accordion-collapse collapse"
                    aria-labelledby="headingFive"
                    data-bs-parent="#accordionExample"
                  >
                    <div className="accordion-body">
                      <p>
                        Ouro Preto consegue manter os viajantes que chegam à
                        cidade entretidos por muitos dias. São dezenas de pontos
                        turísticos a serem visitados, belas cidades nas
                        redondezas para passeios de bate e volta, muitos
                        mirantes que merecem paradas fotográficas e, claro,
                        incontáveis comidinhas mineiras a serem experimentadas.
                        Faltará tempo para tantas atrações. Caso você esteja
                        organizando uma viagem curta, de apenas um final de
                        semana, o melhor é focar no essencial de Ouro Preto para
                        não ficar perdido entre tantas igrejas, museus, minas e
                        povoados encantadores. Caso tenha mais tempo, aproveite
                        para conhecer a arte e arquitetura de Ouro Preto por
                        dentro, não apenas as fachadas. A paisagem de Ouro Preto
                        é deslumbrante, mas é no interior das igrejas e casarões
                        que estão alguns dos maiores tesouros locais.
                      </p>
                    </div>
                  </div>
                </div>
              </div>

              <div id="comment-area" className="mb-5">
                <div id="comment-list" className="mb-3">
                  <div className="comment-item">
                    <div className="list-group w-auto">
                      <div className="list-group-item list-group-item-action d-flex gap-3 py-3 mb-3 border-0 rounded-4">
                        <img
                          src={profilePic}
                          className="rounded-circle flex-shrink-0"
                          alt="Foto de perfil"
                          width="75"
                          height="75"
                        />
                        <div className="d-flex gap-2 w-100 justify-content-between">
                          <div>
                            <p className="m-0">
                              <strong>@nome_do_usuario</strong>
                            </p>
                            <p>
                              <small>17 de Março de 2023</small>
                            </p>
                            <p>
                              <i className="bi bi-star-fill color"></i>
                              <i className="bi bi-star-fill color"></i>
                              <i className="bi bi-star-fill color"></i>
                              <i className="bi bi-star-fill"></i>
                              <i className="bi bi-star-fill"></i>
                            </p>
                            <p>
                              Lorem ipsum dolor sit amet, consetetur sadipscing
                              elitr, sed diam nonumy eirmod tempor invidunt ut
                              labore et dolore magna aliquyam erat, sed diam
                              voluptua. At vero eos et accusam et justo duo
                              dolores et ea rebum. Stet clita kasd gubergren, no
                              sea takimata
                            </p>
                          </div>
                        </div>
                      </div>
                      <div className="list-group-item list-group-item-action d-flex gap-3 py-3 mb-3 border-0 rounded-4">
                        <img
                          src={profilePic}
                          className="rounded-circle flex-shrink-0"
                          alt="Foto de perfil"
                          width="75"
                          height="75"
                        />
                        <div className="d-flex gap-2 w-100 justify-content-between">
                          <div>
                            <p className="m-0">
                              <strong>@nome_do_usuario</strong>
                            </p>
                            <p>
                              <small>17 de Março de 2023</small>
                            </p>
                            <p>
                              <i className="bi bi-star-fill color"></i>
                              <i className="bi bi-star-fill color"></i>
                              <i className="bi bi-star-fill color"></i>
                              <i className="bi bi-star-fill"></i>
                              <i className="bi bi-star-fill"></i>
                            </p>
                            <p>
                              Lorem ipsum dolor sit amet, consetetur sadipscing
                              elitr, sed diam nonumy eirmod tempor invidunt ut
                              labore et dolore magna aliquyam erat, sed diam
                              voluptua. At vero eos et accusam et justo duo
                              dolores et ea rebum. Stet clita kasd gubergren, no
                              sea takimata
                            </p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

                <div className="text-end">
                  <button className="btn btn-light rounded-5 mb-3">
                    Mais avaliações <i className="bi bi-chevron-right"></i>
                  </button>
                </div>

                <div id="comment-form" className="rounded-4">
                  <form className="row g-3">
                    <div className="col-12">
                      <label
                        for="msg"
                        className="form-label"
                        style={{fontSize: "22px"}}
                      >
                        Deixe um comentário
                      </label>
                      <textarea
                        className="form-control"
                        id="msg"
                        rows="3"
                      ></textarea>
                    </div>

                    <div className="col-12" id="rating">
                      Sua avaliação
                      <input
                        type="checkbox"
                        className="btn-check"
                        name="rating"
                        id="star1"
                        autocomplete="off"
                      />
                      <label className="btn btn-outline-light" for="star1">
                        <i className="bi bi-star-fill"></i>
                      </label>
                      <input
                        type="checkbox"
                        className="btn-check"
                        name="rating"
                        id="star2"
                        autocomplete="off"
                      />
                      <label className="btn btn-outline-light" for="star2">
                        <i className="bi bi-star-fill"></i>
                      </label>
                      <input
                        type="checkbox"
                        className="btn-check"
                        name="rating"
                        id="star3"
                        autocomplete="off"
                      />
                      <label className="btn btn-outline-light" for="star3">
                        <i className="bi bi-star-fill"></i>
                      </label>
                      <input
                        type="checkbox"
                        className="btn-check"
                        name="rating"
                        id="star4"
                        autocomplete="off"
                      />
                      <label className="btn btn-outline-light" for="star4">
                        <i className="bi bi-star-fill"></i>
                      </label>
                      <input
                        type="checkbox"
                        className="btn-check"
                        name="rating"
                        id="star5"
                        autocomplete="off"
                      />
                      <label className="btn btn-outline-light" for="star5">
                        <i className="bi bi-star-fill"></i>
                      </label>
                    </div>
                    <div className="col-12">
                      <button
                        type="submit"
                        className="btn btn-warning rounded-5 ps-3 pe-3 float-end"
                      >
                        Enviar comentário
                      </button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
}

export default Itinerary;
