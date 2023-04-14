import React, { useEffect, useState } from "react";
import error from "../../../assets/img/error.png";

function NoItinerary(){
    return(
		<>
			<p className="text-center mt-5"><img src={error} width="200" /></p>
			<h4 className="h4 fw-bold text-center mt-5">Nenhum roteiro encontrada</h4>
			<p className="mb-5 text-center fw-bold">Que cadastrar um roteiro?</p>
			<p className="text-center mb-5"><a href="/me/cadastrar-roteiro" className="btn btn-warning rounded-5">Cadastrar roteiro</a></p>
		</>
	)

}

export default NoItinerary;