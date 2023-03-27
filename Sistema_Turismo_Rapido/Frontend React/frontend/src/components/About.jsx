import React from "react";

import "../assets/css/internas.css";

import Navbar from "./Navbar";
import Footer from "./Footer";

function About() {
  return (
    <>
      <Navbar />
      <div id="main">
        <div className="w-100 top-internas">
          <h3 className="text-center fw-bold">Sobre a Quatour</h3>
          <div className="d-flex justify-content-center">
            <nav aria-label="breadcrumb">
              <ol className="breadcrumb">
                <li className="breadcrumb-item">
                  <a href="/">Home</a>
                </li>
                <li className="breadcrumb-item active" aria-current="page">
                  Sobre a Quatour
                </li>
              </ol>
            </nav>
          </div>
        </div>
        <div className="container">
          <div className="row">
            <div className="col-md-12 col-sm-12">
              <div className="rounded-4 p-5 mb-5 bg-white">
                <h3 className="h3 fw-bold mb-4">
                  Quem somos
                </h3>

                <p>
                  A Quatour é uma agência de turismo e roteiros rápidos que
                  nasceu da paixão por viagens e da vontade de compartilhar
                  experiências incríveis com outras pessoas. Fundada em 2023, a
                  Quatour é uma agência de viagens que oferece roteiros rápidos
                  e personalizados para quem quer conhecer novos lugares sem
                  precisar comprometer todo o seu tempo ou orçamento.
                </p>

                <p>
                  A nossa equipe é formada por profissionais com vasta
                  experiência em viagens, que conhecem bem cada um dos destinos
                  oferecidos pela Quatour e que trabalham incansavelmente para
                  criar roteiros que atendam às necessidades e preferências de
                  cada um dos nossos clientes. Oferecemos viagens de curta
                  duração, mas intensas em experiências e descobertas, que podem
                  ser feitas em um fim de semana, feriado prolongado ou até
                  mesmo em um dia.
                </p>

                <p>
                  Nós acreditamos que viajar é a melhor forma de expandir
                  horizontes, aprender coisas novas, conhecer pessoas e culturas
                  diferentes e, acima de tudo, se divertir. Por isso, na
                  Quatour, nos esforçamos para garantir que nossos clientes
                  tenham a melhor experiência possível durante suas viagens,
                  desde o planejamento até o retorno para casa.
                </p>

                <p>
                  Além de oferecer roteiros rápidos, a Quatour também oferece
                  outros serviços relacionados a viagens, como a organização de
                  viagens corporativas, viagens de incentivo e eventos
                  temáticos, como cruzeiros, festivais de música e outros
                  eventos culturais.
                </p>

                <p>
                  Se você está procurando por uma agência de viagens que oferece
                  roteiros rápidos e personalizados, a Quatour é a escolha certa
                  para você. Entre em contato conosco e descubra todas as opções
                  de destinos e roteiros que temos para oferecer. Viajar nunca
                  foi tão fácil e divertido!
                </p>
              </div>
            </div>
          </div>

          <div className="row mb-5" id="mission-vision-values">
            <div className="col-md-4">
              <div className="rounded-4 bg-palette-color4 p-5 item">
                <h5 className="h4 fw-bold mb-3">Missão</h5>

                <p>
                  Oferecer experiências incríveis e roteiros personalizados,
                  permitindo que os nossos clientes conheçam novos lugares de
                  forma rápida e eficiente, com um atendimento excepcional e um
                  planejamento detalhado para garantir sua satisfação e
                  felicidade.
                </p>
              </div>
            </div>
            <div className="col-md-4">
              <div className="rounded-4 bg-palette-color4 p-5 item">
                <h5 className="h4 fw-bold mb-3">Visão</h5>

                <p>
                  Ser reconhecida como a agência líder em roteiros rápidos e
                  personalizados, criando novas tendências em turismo e gerando
                  impacto positivo na vida das pessoas.
                </p>
              </div>
            </div>
            <div className="col-md-4">
              <div className="rounded-4 bg-palette-color4 p-5 item">
                <h5 className="h4 fw-bold mb-3">Valores</h5>

                <ul>
                  <li>Excelência;</li>
                  <li>Comprometimento;</li>
                  <li>Inovação;</li>
                  <li>Responsabilidade social.</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
}

export default About;
