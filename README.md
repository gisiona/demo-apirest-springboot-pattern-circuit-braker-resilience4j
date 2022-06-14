# demo-apirest-springboot-pattern-circuit-braker-resilience4j
Api desenvolvida para exemplificar o uso do pattern circuit breaker com a biblioteca resilience4j


# Documentação de referência:

Resilience4j - Pattern Circuit Breaker
- https://resilience4j.readme.io/docs/circuitbreaker

Martin Fowler - Circuit Breaker
- https://martinfowler.com/bliki/CircuitBreaker.html

Spring Cloud Sleuth
- https://spring.io/projects/spring-cloud-sleuth

Spring Cloud OpenFeign
- https://spring.io/projects/spring-cloud-openfeign#overview


Payload de Entrada API:
```json
{	
	"cliente": {
        "nome": "Demo Circuit Breaker",
        "cpf": "02304405411",
		    "email":"circuitbreaker@hotmail.com",
				"telefone_celular":"11988889999",
        "idade": 14,
        "uf": "SP",
        "data_nascimento":"20-11-2021",
        "renda_mensal": 2300
    }
}
```

Payload de Saída API:
```json
{
	"id_oferta": "7803b838-8944-4e68-9991-37749dc884a4",
	"piloto": true,
	"cliente": {
		"nome": "Demo Circuit Breaker",
		"cpf": "02304405411",
		"uf": "SP",
		"email": "circuitbreaker@hotmail.com",
		"telefone_celular": "11988889999",
		"renda_mensal": 2300.0,
		"data_nascimento": "20-11-2021"
	},
	"valor": {
		"valor_minimo": 20.00,
		"valor_maximo": 3000.00
	},
	"parcela": {
		"quantidade_minima": 2,
		"quantidade_maxima": 24,
		"valor_minimo": 20.00,
		"valor_maxima": 1000.00
	},
	"vencimento": {
		"data_minima": "2022-06-21",
		"data_maxima": "2022-07-14",
		"data_sugerida": "2022-06-29"
	}
}
```

Parametro de config do resilience4j
- A slidingWindowSize indica com quantas requisições que faremos uma estatística, para saber se ele pode passar para o estado aberto ou para o fechado. Definimos baseado nas últimas requisições que vamos considerar no momento de fazer estatística.

- O minimumNumberOfCalls indica qual o número mínimo de chamadas que temos que fazer até o circuit breaker entrar em ação. No caso, ele vai tentar fazer a requisição uma, duas e na terceira vez o circuit breaker informar que o estado passou para aberto e que não será realizado mais requisições.

- O waitDurationInOpenState é o tempo que vai ser mantido no estado de aberto, configuramos por 50 segundos, visto que o teste vai ser rápido. Mas você pode incluir o tempo que considerar necessário para a sua aplicação.