import React from "react";

import LogoQuatour from "../assets/img/logo-color.svg";

function Register() {
  return (
    <>
      <div id="main">
        <div className="w-100 pb-2 border-bottom">
          <p className="text-center">
            <a href="/">
              <img src={LogoQuatour} width="170" alt="Logo Quatour" />
            </a>
          </p>
        </div>

        <div className="container">
          <div className="row">
            <div className="col-md-12 col-sm-12 pt-5">
              <div className="p-5 bg-white m-auto rounded-4" id="signup">
                <h3 className="h3 fw-bold mb-5">Crie uma conta</h3>
                <p className="mb-5">
                  <strong>Turista</strong>, inscreva-se grátis e tenha acesso
                  aos melhores roteiros pré-definidos para você aproveitar o seu
                  tempo livre. <strong>Turismólogo</strong>, você também pode
                  fazer seu cadastro e planejar roteiros.
                </p>

                <ul className="nav nav-tabs" id="myTab" role="tablist">
                  <li className="nav-item" role="presentation">
                    <button
                      className="nav-link active"
                      id="tourist-tab"
                      data-bs-toggle="tab"
                      data-bs-target="#tourist-tab-pane"
                      type="button"
                      role="tab"
                      aria-controls="tourist-tab-pane"
                      aria-selected="true"
                    >
                      Turista
                    </button>
                  </li>
                  <li className="nav-item" role="presentation">
                    <button
                      className="nav-link"
                      id="tourismologist-tab"
                      data-bs-toggle="tab"
                      data-bs-target="#tourismologist-tab-pane"
                      type="button"
                      role="tab"
                      aria-controls="tourismologist-tab-pane"
                      aria-selected="false"
                    >
                      Turismólogo
                    </button>
                  </li>
                </ul>
                <div className="tab-content" id="tabContent">
                  <div
                    className="tab-pane fade show active p-3"
                    id="tourist-tab-pane"
                    role="tabpanel"
                    aria-labelledby="tourist-tab"
                    tabindex="0"
                  >
                    <form className="row g-3 mt-2">
                      <div className="col-md-6">
                        <label for="username" className="form-label">
                          Usuário
                        </label>
                        <input
                          type="text"
                          className="form-control"
                          id="username"
                        />
                      </div>
                      <div className="col-md-6">
                        <label for="password" className="form-label">
                          Senha
                        </label>
                        <input
                          type="password"
                          className="form-control"
                          id="password"
                        />
                      </div>
                      <div className="col-md-8">
                        <label for="name" className="form-label">
                          Nome
                        </label>
                        <input type="text" className="form-control" id="name" />
                      </div>
                      <div className="col-md-4">
                        <label for="cpf" className="form-label">
                          CPF
                        </label>
                        <input type="text" className="form-control" id="cpf" />
                      </div>

                      <div className="col-md-3">
                        <label for="birthdate" className="form-label">
                          Data nasc.
                        </label>
                        <input
                          type="text"
                          className="form-control"
                          id="birthdate"
                        />
                      </div>
                      <div className="col-md-3">
                        <label for="phone" className="form-label">
                          Telefone
                        </label>
                        <input
                          type="text"
                          className="form-control"
                          id="phone"
                        />
                      </div>
                      <div className="col-md-6">
                        <label for="email" className="form-label">
                          E-mail
                        </label>
                        <input
                          type="email"
                          className="form-control"
                          id="email"
                        />
                      </div>
                      <div className="col-12">
                        <div className="form-check">
                          <input
                            className="form-check-input"
                            type="checkbox"
                            id="terms"
                          />
                          <label className="form-check-label" for="terms">
                            Ao criar uma conta, eu aceito os Termos e condições
                            e a Declaração de privacidade da Quatour, e os
                            Termos e condições da Quatour.
                          </label>
                        </div>
                      </div>
                      <div className="col-12">
                        <button
                          type="submit"
                          className="btn btn-primary rounded-5 ps-3 pe-3 float-end"
                        >
                          Cadastrar
                        </button>
                      </div>
                    </form>
                  </div>
                  <div
                    className="tab-pane fade"
                    id="tourismologist-tab-pane"
                    role="tabpanel"
                    aria-labelledby="tourismologist-tab"
                    tabindex="0"
                  >
                    <form className="row g-3 mt-2">
                      <div className="col-md-6">
                        <label for="username" className="form-label">
                          Usuário
                        </label>
                        <input
                          type="text"
                          className="form-control"
                          id="username"
                        />
                      </div>
                      <div className="col-md-6">
                        <label for="password" className="form-label">
                          Senha
                        </label>
                        <input
                          type="password"
                          className="form-control"
                          id="password"
                        />
                      </div>
                      <div className="col-md-8">
                        <label for="name" className="form-label">
                          Nome
                        </label>
                        <input type="text" className="form-control" id="name" />
                      </div>
                      <div className="col-md-4">
                        <label for="cpf" className="form-label">
                          CPF
                        </label>
                        <input type="text" className="form-control" id="cpf" />
                      </div>
                      <div className="col-12">
                        <label for="cfa" className="form-label">
                          CFA
                        </label>
                        <input type="text" className="form-control" id="cfa" />
                      </div>
                      <div className="col-md-3">
                        <label for="birthdate" className="form-label">
                          Data nasc.
                        </label>
                        <input
                          type="text"
                          className="form-control"
                          id="birthdate"
                        />
                      </div>
                      <div className="col-md-3">
                        <label for="phone" className="form-label">
                          Telefone
                        </label>
                        <input
                          type="text"
                          className="form-control"
                          id="phone"
                        />
                      </div>
                      <div className="col-md-6">
                        <label for="email" className="form-label">
                          E-mail
                        </label>
                        <input
                          type="email"
                          className="form-control"
                          id="email"
                        />
                      </div>
                      <div className="col-12">
                        <div className="form-check">
                          <input
                            className="form-check-input"
                            type="checkbox"
                            id="terms"
                          />
                          <label className="form-check-label" for="terms">
                            Ao criar uma conta, eu aceito os Termos e condições
                            e a Declaração de privacidade da Quatour, e os
                            Termos e condições da Quatour.
                          </label>
                        </div>
                      </div>
                      <div className="col-12">
                        <button
                          type="submit"
                          className="btn btn-primary rounded-5 ps-3 pe-3 float-end"
                        >
                          Cadastrar
                        </button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
              <p className="mt-4 text-muted signup-link text-center">
                Já tem uma conta?{" "}
                <a href="login.html">
                  <strong>Fazer login.</strong>
                </a>
              </p>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Register;
