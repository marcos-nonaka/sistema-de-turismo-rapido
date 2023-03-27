import React from "react";

import ouroPreto from "../assets/img/destinations/ouro-preto.jpg";
import rioDeJaneiro from "../assets/img/destinations/rio-de-janeiro.jpg";
import pelourinho from "../assets/img/destinations/pelourinho.jpg";
import curitiba from "../assets/img/destinations/curitiba.jpg";

function Destinations() {
  return (
    <div className="container">
      <div className="row">
        <div className="col-md-12 col-sm-12 pt-5">
          <h3 className="text-center fw-bold mb-3">Roteiros de viagem</h3>
          <h4 className="text-center mb-5">
            Confira os pricipais roteiros de viagem pelo Brasil
          </h4>

          <div
            className="rounded mb-5 nav justify-content-center"
            id="tour-days"
          >
            <span className="d-block align-middle">Roteiros de até</span>
            <div
              className="btn-group ms-2"
              role="group"
              aria-label="Basic radio toggle button group"
            >
              <input
                type="radio"
                className="btn-check"
                name="btnradio"
                id="btn1"
                autocomplete="off"
              />
              <label className="btn" for="btn1">
                1 dia
              </label>
              <input
                type="radio"
                className="btn-check"
                name="btnradio"
                id="btn2"
                autocomplete="off"
              />
              <label className="btn" for="btn2">
                2 dias
              </label>
              <input
                type="radio"
                className="btn-check"
                name="btnradio"
                id="btn3"
                autocomplete="off"
              />
              <label className="btn" for="btn3">
                3 dias
              </label>
              <input
                type="radio"
                className="btn-check"
                name="btnradio"
                id="btn4"
                autocomplete="off"
              />
              <label className="btn" for="btn4">
                4 dias
              </label>
              <input
                type="radio"
                className="btn-check"
                name="btnradio"
                id="btn5"
                autocomplete="off"
              />
              <label className="btn" for="btn5">
                5 dias
              </label>
              <input
                type="radio"
                className="btn-check"
                name="btnradio"
                id="btn6"
                autocomplete="off"
              />
              <label className="btn" for="btn6">
                6 dias
              </label>
              <input
                type="radio"
                className="btn-check"
                name="btnradio"
                id="btn7"
                autocomplete="off"
              />
              <label className="btn" for="btn7">
                7 dias
              </label>
            </div>
          </div>

          <div id="destinations" className="carousel carousel-dark slide">
            <div className="carousel-inner">
              <div className="carousel-item active" data-bs-interval="10000">
                <div className="row row-cols-1 row-cols-md-3 g-4 pb-5">
                  <div className="col-md-3 col-sm-12">
                    <div className="card position-relative">
                      <div className="thumb position-relative">
                        <img
                          src={ouroPreto}
                          className="card-img-top w-100"
                          alt="Ouro Preto"
                        />
                      </div>
                      <div className="card-body">
                        <h5 className="card-title">
                          Ouro Preto{" "}
                          <button className="btn btn-light heart float-end">
                            <i className="bi bi-heart-fill"></i>{" "}
                            <span>100</span>
                          </button>
                        </h5>
                        <p className="card-text">
                          This is a longer card with supporting text below as a
                          natural lead-in to additional content. This content is
                          a little bit longer.
                        </p>
                        <p className="mb-1">
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-calendar3"></i> 2 dias
                          </span>
                        </p>
                        <p>
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-cash-coin"></i> A partir de{" "}
                            <strong>R$ 140,99</strong>
                          </span>
                        </p>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-3 col-sm-12">
                    <div className="card">
                      <img
                        src={rioDeJaneiro}
                        className="card-img-top"
                        alt="Rio de Janeiro"
                      />
                      <div className="card-body">
                        <h5 className="card-title">
                          Rio de Janeiro{" "}
                          <button className="btn btn-light heart float-end">
                            <i className="bi bi-heart-fill"></i> <span>75</span>
                          </button>
                        </h5>
                        <p className="card-text">
                          This is a longer card with supporting text below as a
                          natural lead-in to additional content. This content is
                          a little bit longer.
                        </p>
                        <p className="mb-1">
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-calendar3"></i> 2 dias
                          </span>
                        </p>
                        <p>
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-cash-coin"></i> A partir de{" "}
                            <strong>R$ 140,99</strong>
                          </span>
                        </p>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-3 col-sm-12">
                    <div className="card">
                      <img
                        src={pelourinho}
                        className="card-img-top"
                        alt="Pelourinho"
                      />
                      <div className="card-body">
                        <h5 className="card-title">
                          Salvador{" "}
                          <button className="btn btn-light heart float-end">
                            <i className="bi bi-heart-fill"></i> <span>20</span>
                          </button>
                        </h5>
                        <p className="card-text">
                          This is a longer card with supporting text below as a
                          natural lead-in to additional content. This content is
                          a little bit longer.
                        </p>
                        <p className="mb-1">
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-calendar3"></i> 2 dias
                          </span>
                        </p>
                        <p>
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-cash-coin"></i> A partir de{" "}
                            <strong>R$ 140,99</strong>
                          </span>
                        </p>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-3 col-sm-12">
                    <div className="card">
                      <img
                        src={curitiba}
                        className="card-img-top"
                        alt="Curitiba"
                      />
                      <div className="card-body">
                        <h5 className="card-title">
                          Curitiba{" "}
                          <button className="btn btn-light heart float-end">
                            <i className="bi bi-heart-fill"></i> <span>35</span>
                          </button>
                        </h5>
                        <p className="card-text">
                          This is a longer card with supporting text below as a
                          natural lead-in to additional content. This content is
                          a little bit longer.
                        </p>
                        <p className="mb-1">
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-calendar3"></i> 2 dias
                          </span>
                        </p>
                        <p>
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-cash-coin"></i> A partir de{" "}
                            <strong>R$ 140,99</strong>
                          </span>
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div className="carousel-item" data-bs-interval="2000">
                <div className="row row-cols-1 row-cols-md-3 g-4 pb-5">
                  <div className="col-md-3 col-sm-12">
                    <div className="card">
                      <img
                        src={ouroPreto}
                        className="card-img-top w-100"
                        alt="Ouro Preto"
                      />
                      <div className="card-body">
                        <h5 className="card-title">
                          Ouro Preto{" "}
                          <button className="btn btn-light heart float-end">
                            <i className="bi bi-heart-fill"></i>{" "}
                            <span>100</span>
                          </button>
                        </h5>
                        <p className="card-text">
                          This is a longer card with supporting text below as a
                          natural lead-in to additional content. This content is
                          a little bit longer.
                        </p>
                        <p className="mb-1">
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-calendar3"></i> 2 dias
                          </span>
                        </p>
                        <p>
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-cash-coin"></i> A partir de{" "}
                            <strong>R$ 140,99</strong>
                          </span>
                        </p>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-3 col-sm-12">
                    <div className="card">
                      <img
                        src={rioDeJaneiro}
                        className="card-img-top"
                        alt="Rio de Janeiro"
                      />
                      <div className="card-body">
                        <h5 className="card-title">
                          Rio de Janeiro{" "}
                          <button className="btn btn-light heart float-end">
                            <i className="bi bi-heart-fill"></i> <span>75</span>
                          </button>
                        </h5>
                        <p className="card-text">
                          This is a longer card with supporting text below as a
                          natural lead-in to additional content. This content is
                          a little bit longer.
                        </p>
                        <p className="mb-1">
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-calendar3"></i> 2 dias
                          </span>
                        </p>
                        <p>
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-cash-coin"></i> A partir de{" "}
                            <strong>R$ 140,99</strong>
                          </span>
                        </p>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-3 col-sm-12">
                    <div className="card">
                      <img
                        src={pelourinho}
                        className="card-img-top"
                        alt="Pelourinho"
                      />
                      <div className="card-body">
                        <h5 className="card-title">
                          Salvador{" "}
                          <button className="btn btn-light heart float-end">
                            <i className="bi bi-heart-fill"></i> <span>20</span>
                          </button>
                        </h5>
                        <p className="card-text">
                          This is a longer card with supporting text below as a
                          natural lead-in to additional content. This content is
                          a little bit longer.
                        </p>
                        <p className="mb-1">
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-calendar3"></i> 2 dias
                          </span>
                        </p>
                        <p>
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-cash-coin"></i> A partir de{" "}
                            <strong>R$ 140,99</strong>
                          </span>
                        </p>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-3 col-sm-12">
                    <div className="card">
                      <img
                        src={curitiba}
                        className="card-img-top"
                        alt="Curitiba"
                      />
                      <div className="card-body">
                        <h5 className="card-title">
                          Curitiba{" "}
                          <button className="btn btn-light heart float-end">
                            <i className="bi bi-heart-fill"></i> <span>35</span>
                          </button>
                        </h5>
                        <p className="card-text">
                          This is a longer card with supporting text below as a
                          natural lead-in to additional content. This content is
                          a little bit longer.
                        </p>
                        <p className="mb-1">
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-calendar3"></i> 2 dias
                          </span>
                        </p>
                        <p>
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-cash-coin"></i> A partir de{" "}
                            <strong>R$ 140,99</strong>
                          </span>
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div className="carousel-item">
                <div className="row row-cols-1 row-cols-md-3 g-4 pb-5">
                  <div className="col-md-3 col-sm-12">
                    <div className="card">
                      <img
                        src={ouroPreto}
                        className="card-img-top w-100"
                        alt="Ouro Preto"
                      />
                      <div className="card-body">
                        <h5 className="card-title">
                          Ouro Preto{" "}
                          <button className="btn btn-light heart float-end">
                            <i className="bi bi-heart-fill"></i>{" "}
                            <span>100</span>
                          </button>
                        </h5>
                        <p className="card-text">
                          This is a longer card with supporting text below as a
                          natural lead-in to additional content. This content is
                          a little bit longer.
                        </p>
                        <p className="mb-1">
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-calendar3"></i> 2 dias
                          </span>
                        </p>
                        <p>
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-cash-coin"></i> A partir de{" "}
                            <strong>R$ 140,99</strong>
                          </span>
                        </p>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-3 col-sm-12">
                    <div className="card">
                      <img
                        src={rioDeJaneiro}
                        className="card-img-top"
                        alt="Rio de Janeiro"
                      />
                      <div className="card-body">
                        <h5 className="card-title">
                          Rio de Janeiro{" "}
                          <button className="btn btn-light heart float-end">
                            <i className="bi bi-heart-fill"></i> <span>75</span>
                          </button>
                        </h5>
                        <p className="card-text">
                          This is a longer card with supporting text below as a
                          natural lead-in to additional content. This content is
                          a little bit longer.
                        </p>
                        <p className="mb-1">
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-calendar3"></i> 2 dias
                          </span>
                        </p>
                        <p>
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-cash-coin"></i> A partir de{" "}
                            <strong>R$ 140,99</strong>
                          </span>
                        </p>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-3 col-sm-12">
                    <div className="card">
                      <img
                        src={pelourinho}
                        className="card-img-top"
                        alt="Pelourinho"
                      />
                      <div className="card-body">
                        <h5 className="card-title">
                          Salvador{" "}
                          <button className="btn btn-light heart float-end">
                            <i className="bi bi-heart-fill"></i> <span>20</span>
                          </button>
                        </h5>
                        <p className="card-text">
                          This is a longer card with supporting text below as a
                          natural lead-in to additional content. This content is
                          a little bit longer.
                        </p>
                        <p className="mb-1">
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-calendar3"></i> 2 dias
                          </span>
                        </p>
                        <p>
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-cash-coin"></i> A partir de{" "}
                            <strong>R$ 140,99</strong>
                          </span>
                        </p>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-3 col-sm-12">
                    <div className="card">
                      <img
                        src={curitiba}
                        className="card-img-top"
                        alt="Curitiba"
                      />
                      <div className="card-body">
                        <h5 className="card-title">
                          Curitiba{" "}
                          <button className="btn btn-light heart float-end">
                            <i className="bi bi-heart-fill"></i> <span>35</span>
                          </button>
                        </h5>
                        <p className="card-text">
                          This is a longer card with supporting text below as a
                          natural lead-in to additional content. This content is
                          a little bit longer.
                        </p>
                        <p className="mb-1">
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-calendar3"></i> 2 dias
                          </span>
                        </p>
                        <p>
                          <span className="btn btn-secondary rounded-5">
                            <i className="bi bi-cash-coin"></i> A partir de{" "}
                            <strong>R$ 140,99</strong>
                          </span>
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <button
              className="carousel-control-prev"
              type="button"
              data-bs-target="#destinations"
              data-bs-slide="prev"
            >
              <span
                className="carousel-control-prev-icon"
                aria-hidden="true"
              ></span>
              <span className="visually-hidden">Previous</span>
            </button>
            <button
              className="carousel-control-next"
              type="button"
              data-bs-target="#destinations"
              data-bs-slide="next"
            >
              <span
                className="carousel-control-next-icon"
                aria-hidden="true"
              ></span>
              <span className="visually-hidden">Next</span>
            </button>
          </div>

          <p className="text-center">
            <a
              href="#"
              className="btn btn-warning btn-lg rounded-pill me-2 ps-4 pe-4 mt-3 mb-5"
            >
              Explorar mais
            </a>{" "}
          </p>
        </div>
      </div>
    </div>
  );
}

export default Destinations;