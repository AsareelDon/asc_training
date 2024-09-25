<template>
  <q-form 
    @submit="onSubmitForm"
    class="q-mt-lg"
  >
    <q-input
      v-if="isRegistration"
      v-model="forms.firstName"
      label="Firstname"
      type="text"
      required
    />
    <q-input 
      v-if="isRegistration"
      v-model="forms.middleName"
      label="Middle Name"
      type="text"
      required
    />
    <q-input 
      v-if="isRegistration"
      v-model="forms.lastName"
      label="Lastname"
      type="text"
      required
    />
    <q-input 
      v-model="forms.userEmail"
      label="Username"
      type="email"
      color="secondary"
      filled
      required
      autofocus
    />
    <div>
      <div class="flex column q-mt-sm">
        <p v-if="hasError.usernameHasError" class="text-body1 text-negative no-margin">
          {{ hasError.usernameHasError? 'Username is invalid!' : '' }}
        </p>
        <a class="text-secondary text-body1 text-bold q-pt-sm" target="_blank">Forgot password?</a>
      </div>
      <div class="q-mt-sm password-container">
        <q-input 
          v-model="forms.userPassword"
          label="Password"
          :type="showPassword? 'text':'password'"
          color="secondary"
          filled
          required
        />
        <q-btn 
          type="button"
          :label="showPassword? 'HIDE':'SHOW'" 
          color="secondary" 
          class="bttn-position"
          flat
          @click="passwordType"
        />
      </div>
      <p v-if="hasError.passwordHasError" class="text-body1 q-pt-xs text-negative no-margin">
        {{ hasError.passwordHasError? 'Password is invalid!' : '' }}
      </p>
    </div>
    <q-btn class="q-mt-md submit-btn" type="submit" label="Submit" color="secondary" />
    
  </q-form>
</template>

<script lang="ts">
import { defineComponent, PropType } from 'vue'

export interface FormInputProps {
  firstName?: string;
  middleName?: string;
  lastName?: string;
  userEmail: string;
  userPassword: string;
}
export default defineComponent({
  name: 'FormComponent',
  props: {
    isRegistration: {
      type: Boolean as PropType<boolean>,
      default: false
    },
    hasError: {
      type: Object as PropType<{
        usernameHasError: boolean,
        passwordHasError: boolean
      }>,
      default: () => ({
        usernameHasError: false,
        passwordHasError: false
      })
    }
  }, 
  data() {
    return {
      forms: {
        firstName: '',
        middleName: '',
        lastName: '',
        userEmail: '',
        userPassword: ''
      },
      rememberAccount: false,
      showPassword: false
    }
  },
  methods: {
    onSubmitForm () {
      this.$emit('submit', this.forms);
    },
    passwordType () {
      this.showPassword = !this.showPassword;
    }
  }
});
</script>
<style>
.password-container {
  position: relative;
}
.password-container .bttn-position {
  position: absolute;
  height: 100%;
  width: 100px;
  right: 0;
  top: 0;
  border-top-left-radius: 0;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.submit-btn {
  height: 50px;
  width: 100%;
}
</style>