<template>
    <PersonInfoData
        :person-info-data="personInfoData"
    ></PersonInfoData>
</template>

<script>
export default {
    components: {
        PersonInfoData: () =>
            import(
                /* webpackChunkName: "ProArtProfPersonInfo" */ "./v-components/personInfo/PersonInfoData"
            ),
    },
    props: {
        personData: {
            type: String,
            required: true,
        },
    },
    computed: {
        personInfoData() {
            return JSON.parse(this.personData); 
        }
    },
};
</script>
