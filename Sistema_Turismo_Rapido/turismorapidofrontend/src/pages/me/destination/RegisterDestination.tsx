import React, {useEffect, useContext, useState} from 'react'
import axios, { AxiosError } from 'axios'
import { Meheader, Menav, Menavgist, Footer } from '../../../components'
import Alertify from "../../../components/alertify/Alertify";
import {Navigate, useNavigate} from 'react-router-dom';
import { getUserLocalStorage } from '../../../store/util'
import { ReactComponent as Loader } from '../../../assets/img/loader.svg'

type UserData = {
  city: string
  attraction: string
  food: string
  hotel: string
  price: string
  days: string
  name: string
}

function RegisterDestination(){
	const [loading, setloading] = useState(false)
	const session = getUserLocalStorage()
	const token = getUserLocalStorage().token
	const [state, setState] = useState<UserData>({
		city: '',
		attraction: '',
		food: '',
		hotel: '',
		price: '',
		days: '',
		name: '',
	})

	const navigate = useNavigate()
	const [dataCity, setDataCity] = useState<any[]>()
	const [foods, setFoods] = useState<string>()
	const [attractions, setAttractions] = useState<string>()
	const [hotels, setHotels] = useState<string>()
	
	const [foodsID, setFoodsID] = useState<string>()
	const [attractionsID, setAttractionsID] = useState<string>()
	const [hotelsID, setHotelsID] = useState<string>()
	
	
	const updateState = (e: any, field: string) => {
		setState((state) => ({ ...state, [field]: e.target.value }))
	}
	
	let cityData
	
	useEffect(() => {
		document.body.classList.remove('bg-internas-login');
		document.body.classList.add('bg-internas-dashboard');
		//console.log(token)
		
		//setDataCity(getData('/cidades', token))
		//console.log(getData('/cidades', token))
		
        const headers = {
            headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json',
				'Authorization': 'Basic ' + token,
            }
        }

		axios.get('http://localhost:3000/cidades', headers).then(response => {
			setDataCity(response.data)
		})
		
	}, []);
	
	//console.log(dataCity)
/*	
	function getData(endpoint: string, token: string){
        const headers = {
            headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json',
				'Authorization': 'Basic ' + token,
            }
        }
		
		const url = 'http://localhost:3000'+endpoint
		
		axios.get(url, headers).then(response => { 
			console.log(endpoint)
			return response.data
		})
		.catch(error => {
			console.log(error.response)
		});

	}
*/


	const handleOnChange = (e: any)=> {
		const option = e.target.value
		
		//console.log(option)
		
		setState((state) => ({ ...state, ['city']: option }))
		console.log(dataCity)
		
		dataCity?.map((item) => {
			if(item.idCidade == option){
				setAttractions(item.atracoes[0].name)
				setHotels(item.hotels[0].name)
				setFoods(item.alimentacoes[0].name)
				
				setAttractionsID(item.atracoes[0].id)
				setHotelsID(item.hotels[0].id)
				setFoodsID(item.alimentacoes[0].id)
				
				
			}
			
		})
	}
	
	//const conteudo = JSON.parse(dataCity)
	//console.log('Cidade: ' + state.city)
	//console.log(dataCity)


  const handleClick = (e: any) => {
    //console.log(e.target.value)
	const target = e.target.value
  }
  
  function handleSubmit(e: any){
    e.preventDefault()
	
	setloading(true)
	
	const data = JSON.stringify({
		"id_cidade": state.city,
		"id_atracao": attractionsID,
		"id_alimentacao": foodsID,
		"id_hotel": hotelsID,
		"valor": state.price,
		"numberOfDays": state.days,	
		"id_client": session.user_id,  
	});	
	

    const headers = {
      headers: {
        'Authorization': 'Basic ' + token,
		'Content-Type': 'application/json'
      }
    }
	//console.log(headers)
	//console.log(data)

	axios.post('http://localhost:3000/roteiros', data, headers).then((response) => {
		if(response.status == 200 || response.status == 201){
			setloading(false)
			Alertify.alert("", "Cadastro realizado com sucesso!")
			navigate('/me/meus-roteiros');
		}else{
			setloading(false)
			console.log(response)
			Alertify.alert('Erro ao tentar realizar cadastro!');	
		}
		setloading(false)
	})

  }


    return(
		<>
		<Meheader />
		<div id="main">
			<div className="container">				
				<div className="row">
					<div className="col-md-3 col-sm-12">
						{ session.role == 'ROLE_TURISTA' ? <Menav /> : <Menavgist /> }
					</div>
					<div className="col-md-9 col-sm-12">
						<h2 className="h2 fw-bold mb-2">Cadastrar roteiro</h2>
						<p className="mb-4">Administre sua experiência na Quatour</p>
				
						<div className="dashboard-content rounded-4 bg-white p-5 mb-5">
						
							<div className="card rounded-4 mb-4">
								<div className="card-header bg-white">
									Detalhes do roteiro
								</div>
								<div className="card-body">
									<form className="row g-3 mt-2" onSubmit={handleSubmit}>
										<div className="col-md-12">
										
											<label htmlFor="city" className="form-label">Cidade</label>
											{/*<select className="form-select" aria-label="Select" id="city" value={state.city} onChange={(e) => updateState(e, 'city')} >*/}
											<select className="form-select" aria-label="Select" id="city" onChange={handleOnChange} >
												<option selected>Selecione uma cidade</option>
												{dataCity?.map((item) => {
													return <option value={item.idCidade} key={item.idCidade}>{item.name}</option>
												})}
											</select>
										</div>
										<div className="col-md-12">
											<label htmlFor="attraction" className="form-label">Atrações</label>
											<input type="hidden" className="form-control" id="attraction" value={attractionsID} onChange={(e) => updateState(e, 'attraction')} />
											<span className="form-control d-block">{attractions ? attractions : '{}'}</span>
										</div>	
				
										<div className="col-md-12">
											<label htmlFor="food" className="form-label">Alimentação</label>
											<input type="hidden" className="form-control" id="food" value={foodsID} onChange={(e) => updateState(e, 'food')} />
											<span className="form-control d-block">{foods ? foods : '{}'}</span>
										</div>
										<div className="col-md-12">
											<label htmlFor="hotel" className="form-label">Hotéis</label>
											<input type="hidden" className="form-control" id="hotel" value={hotelsID} onChange={(e) => updateState(e, 'hotel')} />
											<span className="form-control d-block">{hotels ? hotels : '{}'}</span>
										</div>
										
										
										<div className="col-md-6">
											<label htmlFor="price" className="form-label">Valor</label>
											<input type="text" className="form-control" id="price" value={state.price} onChange={(e) => updateState(e, 'price')} />
										</div>
										<div className="col-md-6">
											<label htmlFor="days" className="form-label">Quantidade de dias</label>
											<input type="text" className="form-control" id="days" value={state.days} onChange={(e) => updateState(e, 'days')} />
										</div>
										<div className="col-md-12">
											{/*<label htmlFor="name" className="form-label">Nome</label>*/}
											<input type="hidden" className="form-control" id="name" value={session.user_id} onChange={(e) => updateState(e, 'name')} />
										</div>										
										<div className="col-12">
											<button type="submit" className="btn btn-warning rounded-5 ps-3 pe-3 float-end">{loading ? <Loader className="spinner" /> : 'Salvar roteiro'}</button>
										</div>
									</form>
								</div>
							</div>	
						</div>
					</div>
				</div>

			</div>
		</div>
		
		<Footer />
		</>
	)

}

export default RegisterDestination;