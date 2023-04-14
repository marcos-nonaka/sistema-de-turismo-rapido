import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Navbar, Navuser, Footer, ImageComponent } from '../../../components'
import { getUserLocalStorage } from '../../../store/util'
import { useAPI } from 'data/API'

import Florianopolis from '../../../assets/img/destinations/florianopolis.png'
import SaoPaulo from '../../../assets/img/destinations/sao-paulo.png'
import RiodeJaneiro from '../../../assets/img/destinations/rio-de-janeiro.png'
import OuroPreto from '../../../assets/img/destinations/ouro-preto.png'
import Curitiba from '../../../assets/img/destinations/curitiba.png'
import Olinda from '../../../assets/img/destinations/olinda.png'
import Salvador from '../../../assets/img/destinations/salvador.png'

//import ImageComponent from '../../../components/img';

interface Roteiro {
  numberOfDays: number
  valor: number
  cidade: any
  id: number
  name: string
  cep: string
  latitude: number
  longitude: number
  // outras propriedades da cidade
}

type QueryData = {
  query: string;
}


function ItinerarySearch() {
	const api = useAPI()
	const [queyResult, setQueryResult] = useState<any[]>([])
	const [state, setState] = useState<QueryData>({ query: '' })
	const userData = getUserLocalStorage() != null ? getUserLocalStorage() : ''
	const [loading, setloading] = useState(false);
	const [result, setResult] = useState(true);
	//const token = getUserLocalStorage().token
	//const token = 'Basic ' + btoa('admin:123')
	
	const onUpdate = (e: React.ChangeEvent<any>, name: 'query') => {
		setState((state) => ({ ...state, [name]: e.target.value }))
	}
	
	function encode_utf8(s: any) {
	  return unescape(encodeURIComponent(s));
	}

	function handleSubmit(e: any){
		e.preventDefault()
		
		//setloading(true)

		const headers = {
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json',
				'Authorization': 'Basic ' + btoa('admin:123'),
			}
		}
		
		axios.get('http://localhost:3000/roteiros?name='+state.query, headers).then(response => {
			console.log(response.data)
			
			if(response.status == 204){
				setResult(false)
			}else{
				setResult(true)
				setQueryResult(response.data)
			}
		})

		//console.log(roteiros)
	}




/*
  useEffect(() => {
    api.get('/roteiros?name=Flori', {}).then((res: Roteiro[]) => {
      setRoteiros(res)
    })
  }, [api, setRoteiros])

  const [resultadosPesquisa, setResultadosPesquisa] = useState<Array<Roteiro>>([])

  const handleSearch = () => {
    const searchInput = document.getElementById('search') as HTMLInputElement
    const query = searchInput.value.toLowerCase().trim()
	
	
	
    if (!query) {
      setResultadosPesquisa([])
      return
    }

    const filteredCidades = roteiros.filter((roteiro) => roteiro.cidade.name.toLowerCase().includes(query))

    if (filteredCidades.length > 0) {
      setResultadosPesquisa(filteredCidades)
    } else {
      setResultadosPesquisa([])
    }
	
	console.log(resultadosPesquisa)
	
  }

*/

  return (
    <div>
      { userData.username ? <Navuser /> : <Navbar /> }
      <div id='main'>
        <div className='w-100 top-internas'>
          <h3 className='text-center fw-bold'>Pesquisa de roteiros</h3>
          <div className='d-flex justify-content-center'>
            <nav aria-label='breadcrumb'>
              <ol className='breadcrumb'>
                <li className='breadcrumb-item'>
                  <a href='/'>Home</a>
                </li>
                <li className='breadcrumb-item active' aria-current='page'>
                  Pesquisa de roteiros
                </li>
              </ol>
            </nav>
          </div>
        </div>

        <div className='container'>
          <div className='row'>
            <div className='col-md-12 col-sm-12'>
              <div className='w-100 rounded-4 bg-white p-5 mb-5'>
                <form onSubmit={handleSubmit}>
				<div className='input-group mb-3'>
                  <input
                    type='text'
                    className='form-control rounded-5'
                    id='search'
                    placeholder='Pesquisar por cidade com algum roteiro'
                    aria-label='Pesquisar roteiro'
                    aria-describedby='button-addon2'
					name='query'
					value={state.query}
						onChange={(e) => onUpdate(e, 'query')}
                  />
                  <button
                    className='btn btn-outline-secondary btn-lg'
                    type='submit'
                    id='button-search'
                  >
                    <i className='bi bi-search'></i>
                  </button>
				  
                </div></form>
                <div id='filters'>
                  <div className='btn-group'>
                    <button
                      className='btn btn-outline-secondary dropdown-toggle rounded-5'
                      type='button'
                      data-bs-toggle='dropdown'
                      aria-expanded='false'
                    >
                      Duração
                    </button>

                    <div className='dropdown-menu p-3'>
                      <div className='form-check'>
                        <input className='form-check-input' type='radio' name='days' id='days1' />
                        <label className='form-check-label' htmlFor='days1'>
                          1 dia
                        </label>
                      </div>
                      <div className='form-check'>
                        <input className='form-check-input' type='radio' name='days' id='days2' />
                        <label className='form-check-label' htmlFor='days2'>
                          2 dias
                        </label>
                      </div>
                      <div className='form-check'>
                        <input className='form-check-input' type='radio' name='days' id='days3' />
                        <label className='form-check-label' htmlFor='days3'>
                          3 dias
                        </label>
                      </div>
                      <div className='form-check'>
                        <input className='form-check-input' type='radio' name='days' id='days4' />
                        <label className='form-check-label' htmlFor='days4'>
                          4 dias
                        </label>
                      </div>
                      <div className='form-check'>
                        <input className='form-check-input' type='radio' name='days' id='days5' />
                        <label className='form-check-label' htmlFor='days5'>
                          5 dias
                        </label>
                      </div>
                      <div className='form-check'>
                        <input className='form-check-input' type='radio' name='days' id='days6' />
                        <label className='form-check-label' htmlFor='days6'>
                          6 dias
                        </label>
                      </div>
                      <div className='form-check'>
                        <input className='form-check-input' type='radio' name='days' id='days7' />
                        <label className='form-check-label' htmlFor='days7'>
                          7 dias
                        </label>
                      </div>
                    </div>
                  </div>

                  <div className='btn-group'>
                    <button
                      className='btn btn-outline-secondary dropdown-toggle rounded-5'
                      type='button'
                      data-bs-toggle='dropdown'
                      aria-expanded='false'
                    >
                      Custo
                    </button>

                    <div className='dropdown-menu p-3'>
                      <div className='form-check'>
                        <input className='form-check-input' type='radio' name='cost' id='cost1' />
                        <label className='form-check-label' htmlFor='cost1'>
                          $
                        </label>
                      </div>
                      <div className='form-check'>
                        <input className='form-check-input' type='radio' name='cost' id='cost2' />
                        <label className='form-check-label' htmlFor='cost2'>
                          $$
                        </label>
                      </div>
                      <div className='form-check'>
                        <input className='form-check-input' type='radio' name='cost' id='cost3' />
                        <label className='form-check-label' htmlFor='cost3'>
                          $$$
                        </label>
                      </div>
                      <div className='form-check'>
                        <input className='form-check-input' type='radio' name='cost' id='cost4' />
                        <label className='form-check-label' htmlFor='cost4'>
                          $$$$
                        </label>
                      </div>
                    </div>
                  </div>

                  <div className='btn-group'>
                    <button
                      className='btn btn-outline-secondary dropdown-toggle rounded-5'
                      type='button'
                      data-bs-toggle='dropdown'
                      aria-expanded='false'
                    >
                      Popularidade
                    </button>

                    <div className='dropdown-menu p-3'>
                      <div className='form-check'>
                        <input
                          className='form-check-input'
                          type='radio'
                          name='popularity'
                          id='popularity1'
                        />
                        <label className='form-check-label' htmlFor='popularity1'>
                          Pop 1
                        </label>
                      </div>
                      <div className='form-check'>
                        <input
                          className='form-check-input'
                          type='radio'
                          name='popularity'
                          id='popularity2'
                        />
                        <label className='form-check-label' htmlFor='popularity2'>
                          Pop 2
                        </label>
                      </div>
                      <div className='form-check'>
                        <input
                          className='form-check-input'
                          type='radio'
                          name='popularity'
                          id='popularity3'
                        />
                        <label className='form-check-label' htmlFor='popularity3'>
                          Pop 3
                        </label>
                      </div>
                    </div>
                  </div>
                  <button type='button' className='btn text-mutted'>
                    Limpar filtros
                  </button>
                </div>
              </div>
			  
			  <div className="p-5 pt-0" id="search-result">
				<h3 className="h3 text-center fw-bold border-bottom pb-5 mb-5">Resultados</h3>
				
				{result ? (
					queyResult?.map((item) => (
						//let img = item.cidade.photo
						
						<div className="tour-list" key={item.idRoteiro}>
							<div className="row mb-4 border-bottom pb-5">
								<div className="col-md-4 col-sm-6" >
								<div className="city-img" style={{ backgroundImage:`url(${OuroPreto})` }} ></div>
									{/*<img src={OuroPreto} className='w-100 rounded-4' alt='Ouro Preto' />*/}
								</div>
								<div className="col-md-8 col-sm-6 pt-3">
									<h4 className="h4 fw-bold">{item.cidade.name}</h4>
									<p>{item.cidade.description}</p>
									<p className="mb-1"><span className="btn btn-secondary rounded-5"><i className="bi bi-calendar3"></i> {item.days} dias</span> <span className="btn btn-secondary rounded-5"><i className="bi bi-cash-coin"></i> A partir de <strong>R$ {item.valor}</strong></span></p>
									<p className="m-0">Latitude: {item.cidade.latitude} Longitude: {item.cidade.latitude}</p>
									<p className="mb-3">Cadastrado por: Gilmar</p>
									<a href={'roteiro?id='+item.idRoteiro} className="btn btn-warning btn-lg rounded-pill me-2 ps-4 pe-4">Ver roteiro</a>
								</div>   
							</div>
						</div>

					))

				) : (
					<div className="alert alert-danger text-center" role="alert">
					  <i className="bi bi-exclamation-triangle me-2"></i> Nenhum roteiro encontrado para a pesquisa realizada!
					</div>
				)}
			  </div>

            </div>
          </div>
        </div>
      </div>

      <Footer />
    </div>
  )
}

export default ItinerarySearch
