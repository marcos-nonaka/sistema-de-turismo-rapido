import React from "react";

import logoFooter from "../../../assets/img/logo-footer.svg";

function Footer(){
    return(
    <footer className="pt-5 pb-5">
      <div className="container">
        <div className="row">
          <div className="col-md-6">
            <nav className="nav initial-nav">
              <a className="nav-link logo" href="/">
                <img src={logoFooter} className="align-middle" alt="Logo Footer" />
              </a>
              <a className="nav-link" href="/">
                Home
              </a>
              <a className="nav-link" href="/quem-somos">
                Sobre a Quatour
              </a>
              <a className="nav-link" href="/pesquisar-roteiro">
                Roteiros
              </a>
              <a className="nav-link" href="/fale-conosco">
                Fale conosco
              </a>
            </nav>
          </div>
          <div className="col-md-6">
            <ul className="nav justify-content-end final-nav">
              <li className="nav-item">
                <a className="nav-link social" aria-current="page" href="#">
                  <i className="bi bi-instagram"></i>
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link social" href="#">
                  <i className="bi bi-facebook"></i>
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link social" href="#">
                  <i className="bi bi-twitter"></i>
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link">
                  © 2023 Quatour - Todos os direitos reservados.
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </footer>
	)

}

export default Footer;