<template>
    <nav class="navbar adminHeaderDiv sticky-top navbar-dark bg-light">
        <router-link id="adminHeaderTitleDiv" class="routerLink" :to="{ name : 'AdminMain'}">
            <h3>SadaRada halduskeskkond</h3>
        </router-link>
    </nav>
</template>

<script>
    export default {
        name: 'Header',
        methods: {
            openSidebar() {
                document.getElementById('sidebar').style.visibility = 'unset';
            }
        },
    };
</script>

<style scoped>
    .adminHeaderDiv {
        text-align: center !important;
        height: 4em;
        display: flex;
    }

    #adminHeaderTitleDiv {
        /*margin-top: 1em;*/
        /*margin-left: 4em;*/
        border: none !important;
        margin-top: 0.2em;
    }
</style>
