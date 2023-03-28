import React from "react";

import logoFooter from "../assets/img/logo-footer.svg";

function Footer() {
  return (
    <footer class="pt-5 pb-5">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <nav class="nav initial-nav">
              <a class="nav-link logo" href="/">
                <img src={logoFooter} class="align-middle" alt="Logo Footer" />
              </a>
              <a class="nav-link" href="/">
                Home
              </a>
              <a class="nav-link" href="/quem-somos">
                Sobre a Quatour
              </a>
              <a class="nav-link" href="/pesquisar-roteiro">
                Roteiros
              </a>
              <a class="nav-link" href="/fale-conosco">
                Fale conosco
              </a>
            </nav>
          </div>
          <div class="col-md-6">
            <ul class="nav justify-content-end final-nav">
              <li class="nav-item">
                <a class="nav-link social" aria-current="page" href="#">
                  <i class="bi bi-instagram"></i>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link social" href="#">
                  <i class="bi bi-facebook"></i>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link social" href="#">
                  <i class="bi bi-twitter"></i>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link">
                  © 2023 Quatour - Todos os direitos reservados.
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
