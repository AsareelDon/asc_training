<template>
  <q-layout>
    <q-page-container>
      <q-page class="row">
        <div class="col" style="border: 1px solid red;">This is for background image</div>
        <div class="col-4 self-start q-my-xl q-mx-xl">
          <h3 class="q-mb-md text-grey-10">Login here</h3>
          <p class="text-h5 text-grey-10">
            Lorem ipsum, dolor sit amet consectetur adipisicing elit. Fugiat natus omnis facere doloremque!
          </p>
          <FormComponent @submit="handleFormSubmit"/>
        </div>
      </q-page>
    </q-page-container>
  </q-layout>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import FormComponent from 'src/components/FormComponent.vue';

export default defineComponent({
  components: {
    FormComponent
  },

  setup() {
    const handleFormSubmit = (forms: {
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
