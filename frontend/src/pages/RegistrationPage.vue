<template>
  <q-layout>
    <q-page-container>
      <q-page padding>
        <h3>Signup here Page</h3>
        <FormComponent @submit="handleFormSubmit"/>
      </q-page>
    </q-page-container>
  </q-layout>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import FormComponent from 'src/components/FormComponent.vue';

export default defineComponent({
  components: {
    FormComponent
  },

  setup() {
    const handleFormSubmit = (forms: {
      firstName: string;
      middleName: string;
      lastName: string;
      userEmail: string;
      userPassword: string;
    }) => {
      console.log('Credentials: ', forms);
    };

    return {
      handleFormSubmit
    };
  }
});
</script>
