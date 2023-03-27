import React from "react";

import "../assets/css/internas.css";

import Navbar from "./Navbar";
import Footer from "./Footer";

function TalkWithUs() {
  return (
    <>
      <Navbar />
      <div id="main">
        <div className="w-100 top-internas">
          <h3 className="text-center fw-bold">Fale conosco</h3>
          <div className="d-flex justify-content-center">
            <nav aria-label="breadcrumb">
              <ol className="breadcrumb">
                <li className="breadcrumb-item">
                  <a href="/">Home</a>
                </li>
                <li className="breadcrumb-item active" aria-current="page">
                  Fale conosco
                </li>
              </ol>
            </nav>
          </div>
        </div>

        <div className="container">
          <div className="row">
            <div className="col-md-12 col-sm-12">
              <div className="rounded-4 p-5 mb-5 bg-white">
                <h3 className="h3 fw-bold mb-4">Fale conosco</h3>

                <p className="mb-5">
                  Se você tiver alguma dúvida, sugestão ou comentário, não
                  hesite em entrar em contato conosco. A equipe da Quatour está
                  sempre pronta para ajudá-lo da melhor maneira possível.
                </p>

                <form className="row g-3" id="contact">
                  <div className="col-md-4">
                    <label for="name" className="form-label">
                      Nome
                    </label>
                    <input type="text" className="form-control" id="name" />
                  </div>
                  <div className="col-md-4">
                    <label for="email" className="form-label">
                      E-mail
                    </label>
                    <input type="email" className="form-control" id="email" />
                  </div>
                  <div className="col-md-4">
                    <label for="phone" className="form-label">
                      Telefone
                    </label>
                    <input type="text" className="form-control" id="phone" />
                  </div>
                  <div className="col-12">
                    <label for="message" className="form-label">
                      Sua mensagem
                    </label>
                    <textarea
                      className="form-control"
                      id="message"
                      rows="5"
                    ></textarea>
                  </div>

                  <div className="col-12">
                    <button
                      type="submit"
                      className="btn btn-custom-warning ps-3 pe-3 float-end rounded-5"
                    >
                      Enviar
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>

      <Footer />
    </>
  );
}

export default TalkWithUs;
