<template>
<div id="footer-component-vue">
        <h1>My Todo App!</h1>
        <v-language
            :language-data="languageData"
        >
         </v-language>
</div>
</template>

<script>
import LanguageSide from './v-components/Language'

export default {
    components: {
        "v-language": LanguageSide,
    },
    props: {
        linkTo: {
            type: String,
            required: false,
        },
    },
    computed: {
        languageData() {
            return {
                linkTo: this.$props.linkTo,
            };
        },
    },
};


</script>

<style lang="scss" scoped>
p {
  font-size: 2em;
  text-align: center;
}
</style>