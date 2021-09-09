navigator.mediaDevices.getUserMedia({audio:true}).then(
    stream=>{
        const mediarecorder = new MediaRecorder(stream);
        document.querySelector('#start').addEventListener('click',function (e){
            console.log('it is working');
            e.preventDefault();
            mediarecorder.start();
            document.querySelector('#start').style.background="red";
        });
        var audioChunks=[];
        mediarecorder.addEventListener("dataavailable",function (event){
            audioChunks.push(event.data);
        });
        mediarecorder.addEventListener("stop",function (){
            const audioBlob=new Blob(audioChunks,{
                type:'audio/wav'
            });
            const audioUrl = URL.createObjectURL(audioBlob);
                var audio = document.createElement('audio');
                var audio = document.createElement('audio');
                audio.href=audioUrl;
                audio.controls=true;
                audio.autoplay=true;

            document.querySelector('#audio').appendChild(audio);
                audioChunks=[];
        });
        document.querySelector('#stop').addEventListener('click',function (e){
            e.preventDefault();
            mediarecorder.stop();
        });
    }
)