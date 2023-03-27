import React from "react";

import Banner1 from "../assets/img/ban2_1.jpg";
import Banner1mobile from "../assets/img/ban2_2.jpg";

function Slider() {
  return (
    <div id="slider" className="carousel slide">
      <div className="carousel-inner">
        <div className="carousel-item active">
          <img src={Banner1} className="d-block w-100 ban_desktop" alt="Banner 1" />
          <img src={Banner1mobile} className="w-100 ban_mobile" alt="Banner 1" />
          <div className="carousel-caption d-none d-md-block">
            <a
              href="pesquisar-roteiro.html"
              className="btn btn-warning btn-lg rounded-pill me-2 ps-4 pe-4"
            >
              Explorar roteiros
            </a>
          </div>
        </div>
      </div>

      <button
        className="carousel-control-prev"
        type="button"
        data-bs-target="#slider"
        data-bs-slide="prev"
      >
        <span className="carousel-control-prev-icon" aria-hidden="true"></span>
        <span className="visually-hidden">Previous</span>
      </button>
      <button
        className="carousel-control-next"
        type="button"
        data-bs-target="#slider"
        data-bs-slide="next"
      >
        <span className="carousel-control-next-icon" aria-hidden="true"></span>
        <span className="visually-hidden">Next</span>
      </button>
    </div>
  );
}

export default Slider;
