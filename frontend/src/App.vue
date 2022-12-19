<template>
  <div id="app">
    <h1 class="text-center">Pizze</h1>

    <div class="row justify-content-center gap-4 mt-5">
      <div v-for="pizza in pizzas" :key="pizza.id" class="card" style="width: 18rem;">
        <div class="card-body">
          <h5 class="card-title">{{ pizza.name }}</h5>
          <h6 class="card-subtitle mb-2 text-muted">Prezzo: €{{ pizza.price }}</h6>
          <p class="card-text">{{ pizza.description }}</p>
          <a href="#" class="card-link">Modifica</a>
          <a href="#" class="card-link">Elimina</a>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'App',
  components: {
    
  },

  data() {
    return {
      apiUrl: 'http://localhost:8080/api/1/',
      pizzas: [],
    }
  },
  methods: {
    getAllPizzas() {
      axios.get(this.apiUrl + "pizza/all")
        .then(response => {
          this.pizzas = response.data
        })
        .catch(error => {
          console.log(error)
        })
    }
  },
  mounted() {
    this.getAllPizzas()
  }
}
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
