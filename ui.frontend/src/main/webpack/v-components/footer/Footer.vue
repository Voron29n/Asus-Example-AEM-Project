<template>
<div id="footer-component-vue">
    <vfooter>
        <h1>My Todo App!</h1>
        <v-language
            :language-data="languageData"
        >
         </v-language>
    </vfooter>
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

<style lang="stylus" scoped>
p {
  font-size: 2em;
  text-align: center;
}
</style>